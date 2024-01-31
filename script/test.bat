@echo off

:: Set the paths
set "batchFilePath=C:\Program Files\BakkesMod\RocketLeague.bat"
set "vbsFilePath=C:\Program Files\BakkesMod\RocketLeague.vbs"
set "shortcutPath=%userprofile%\Desktop\RocketLeagueShortcut.lnk"
set "iconPath=C:\Steam\steam\games\3ea06e4358d60a692914fd961298de33ad4073b2.ico"  :: Specify the path to your icon file

:: Create the RocketLeague.bat file
echo @echo off > "%batchFilePath%"
echo start "" "C:\Program Files\BakkesMod\BakkesMod.exe" >> "%batchFilePath%"
echo start "" "steam://rungameid/252950" >> "%batchFilePath%"

:: Create the vbs file to run the script without a cmd window

echo Set WshShell = CreateObject("WScript.Shell") > "%vbsFilePath%"
echo WshShell.Run chr(34) ^& "%batchFilePath%" ^& chr(34), 0 >> "%vbsFilePath%"
echo Set WshShell = Nothing >> "%vbsFilePath%"

:: Create a desktop shortcut
echo Set WshShell = WScript.CreateObject("WScript.Shell") > CreateShortcut.vbs
echo desktopPath = WshShell.SpecialFolders("Desktop") >> CreateShortcut.vbs
echo Set shortcut = WshShell.CreateShortcut(desktopPath ^& "\Rocket League.lnk") >> CreateShortcut.vbs
echo shortcut.TargetPath = "%vbsFilePath%" >> CreateShortcut.vbs
echo shortcut.IconLocation = "D:\Steam\steam\games\3ea06e4358d60a692914fd961298de33ad4073b2.ico" >> CreateShortcut.vbs
echo shortcut.Save >> CreateShortcut.vbs
cscript CreateShortcut.vbs
del CreateShortcut.vbs

echo VBScript file and shortcut created successfully.
