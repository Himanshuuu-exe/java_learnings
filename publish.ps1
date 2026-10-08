$Source = "C:\Users\chira\javaHC"
$Publish = "C:\Users\chira\javaHC-github"
$MappingFile = Join-Path $Publish "mapping.json"

Write-Host ""
Write-Host "========================================"
Write-Host "       Java GitHub Publisher"
Write-Host "========================================"
Write-Host ""

# --------------------------------------------------
# Folder -> GitHub number mapping
# --------------------------------------------------

$InitialMapping = [ordered]@{
    "may26+before" = 1
    "may28" = 2
    "may30" = 3
    "june2" = 4
    "04june" = 5
    "06june" = 6
    "06juneTesting" = 7
    "11june" = 8
    "13june" = 9
    "16june" = 10
    "18june" = 11
    "20june" = 12
    "23june" = 13
    "25june" = 14
    "27june" = 15
    "30june" = 16
    "my-utils" = 17
    "testCases" = 18
    "02july" = 19
    "04july" = 20
    "07july" = 21
    "09july" = 22
    "11july" = 23
    "14july" = 24
    "16july" = 25
    "awt-swing" = 26
    "23july" = 27
    "25july" = 28
    "28july" = 29
    "01august" = 30
    "itext_testing" = 31
    "rdbms-eg" = 32
    "19sept_JDBC_CODE+old" = 33
    "23sept" = 34
    "29sept_multithreading_starts" = 35
    "1oct_lambdas" = 36
    "3oct_threading_continue_2" = 37
    "6oct_last_threading" = 38
}

# --------------------------------------------------
# Create mapping file if it does not exist
# --------------------------------------------------

if (!(Test-Path $MappingFile)) {
    $InitialMapping | ConvertTo-Json | Set-Content $MappingFile
}

# --------------------------------------------------
# Load mapping
# --------------------------------------------------

$Mapping = Get-Content $MappingFile -Raw | ConvertFrom-Json

$Map = @{}

$Mapping.PSObject.Properties | ForEach-Object {
    $Map[$_.Name] = [int]$_.Value
}

# --------------------------------------------------
# Display mapping
# --------------------------------------------------

Write-Host "Available GitHub folders:"
Write-Host ""

$Map.GetEnumerator() |
    Sort-Object Value |
    ForEach-Object {
        Write-Host "$($_.Value) -> $($_.Key)"
    }

Write-Host ""
Write-Host "========================================"
Write-Host ""

# --------------------------------------------------
# Ask which folder to publish
# --------------------------------------------------

$Choice = Read-Host "Enter the GitHub folder number to publish (or Q to quit)"

if ($Choice -eq "Q" -or $Choice -eq "q") {
    Write-Host ""
    Write-Host "Cancelled."
    exit
}

# Validate number
$SelectedNumber = 0

if (!( [int]::TryParse($Choice, [ref]$SelectedNumber) )) {
    Write-Host ""
    Write-Host "Invalid number."
    Read-Host "Press ENTER to exit"
    exit
}

# Find local folder belonging to selected number
$SelectedFolder = $null

foreach ($Item in $Map.GetEnumerator()) {
    if ($Item.Value -eq $SelectedNumber) {
        $SelectedFolder = $Item.Key
        break
    }
}

if ($null -eq $SelectedFolder) {
    Write-Host ""
    Write-Host "No folder is mapped to number $SelectedNumber."
    Read-Host "Press ENTER to exit"
    exit
}

$SourceFolder = Join-Path $Source $SelectedFolder
$DestinationFolder = Join-Path $Publish $SelectedNumber

# --------------------------------------------------
# Check source folder
# --------------------------------------------------

if (!(Test-Path $SourceFolder)) {
    Write-Host ""
    Write-Host "Source folder not found:"
    Write-Host $SourceFolder
    Read-Host "Press ENTER to exit"
    exit
}

Write-Host ""
Write-Host "Selected:"
Write-Host "Local folder : $SelectedFolder"
Write-Host "GitHub folder: $SelectedNumber"
Write-Host ""

# --------------------------------------------------
# Create destination folder
# --------------------------------------------------

if (!(Test-Path $DestinationFolder)) {
    New-Item -ItemType Directory -Path $DestinationFolder | Out-Null
}

# --------------------------------------------------
# Synchronize ONLY selected folder
# --------------------------------------------------

Write-Host "Synchronizing only folder $SelectedNumber..."
Write-Host ""

robocopy `
    $SourceFolder `
    $DestinationFolder `
    /E `
    /XD ".git" "node_modules" "bin" "obj" "target" `
    /XF "*.class" `
    /NFL `
    /NDL `
    /NJH `
    /NJS `
    /NP | Out-Null

Write-Host ""
Write-Host "Synchronization complete."
Write-Host ""

# --------------------------------------------------
# Git status
# --------------------------------------------------

Set-Location $Publish

Write-Host "Git changes:"
Write-Host ""

git status --short

Write-Host ""

$Changes = git status --porcelain

if (!$Changes) {
    Write-Host "No changes detected."
    Write-Host "Nothing to commit or push."
    Write-Host ""
    Read-Host "Press ENTER to exit"
    exit
}

# --------------------------------------------------
# Show change summary
# --------------------------------------------------

Write-Host "Change summary:"
Write-Host ""

git diff --stat

Write-Host ""
Write-Host "========================================"
Write-Host ""

$Answer = Read-Host "Commit and push folder $SelectedNumber to GitHub? (Y/N)"

if ($Answer -ne "Y" -and $Answer -ne "y") {

    Write-Host ""
    Write-Host "Nothing was committed or pushed."
    Write-Host ""

    Read-Host "Press ENTER to exit"
    exit
}

# --------------------------------------------------
# Commit
# --------------------------------------------------

$Commit = Read-Host "Enter commit message"

if ([string]::IsNullOrWhiteSpace($Commit)) {

    Write-Host ""
    Write-Host "Commit message cannot be empty."
    Write-Host "Nothing was pushed."

    Read-Host "Press ENTER to exit"
    exit
}

Write-Host ""
Write-Host "Adding folder $SelectedNumber..."

git add $SelectedNumber

Write-Host ""
Write-Host "Creating commit..."

git commit -m $Commit

if ($LASTEXITCODE -ne 0) {

    Write-Host ""
    Write-Host "Commit failed."
    Write-Host "Nothing was pushed."

    Read-Host "Press ENTER to exit"
    exit
}

# --------------------------------------------------
# Push
# --------------------------------------------------

Write-Host ""
Write-Host "Pushing to GitHub..."

git push

if ($LASTEXITCODE -eq 0) {

    Write-Host ""
    Write-Host "========================================"
    Write-Host "Successfully pushed folder $SelectedNumber!"
    Write-Host "========================================"
}
else {

    Write-Host ""
    Write-Host "Push failed."
    Write-Host "Your commit is still saved locally."
}

Write-Host ""
Read-Host "Press ENTER to exit"