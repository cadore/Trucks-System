; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{956B7C97-CBD2-43F4-AD2D-513805F5A9E1}
AppName=Trucks System - CadoreSistemas
AppVersion=1.5.5
;AppVerName=Trucks System - CadoreSistemas 1.5.4
AppPublisher=Cadore Sistemas
AppPublisherURL=http://cadoresistemas.com.br
AppSupportURL=http://cadoresistemas.com.br
AppUpdatesURL=http://cadoresistemas.com.br
DefaultDirName=C:\CadoreSistemas\TrucksSystem
DisableDirPage=yes
DefaultGroupName=Trucks System - CadoreSistemas
OutputDir=E:\CADORE\Programação\JavaSE\Backup-truck_system\trucks_system\store
OutputBaseFilename=TrucksSystem_setup_1.5.5
SetupIconFile=E:\CADORE\Programação\JavaSE\Backup_SystemNotesEmission\SystemNotesEmission\src\Images\icone.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "E:\CADORE\Programação\JavaSE\Backup-truck_system\trucks_system\store\start_truckssystem.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "E:\CADORE\Programação\JavaSE\Backup-truck_system\trucks_system\store\UpdateTrucksSystem.jar"; DestDir: "{app}"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\Trucks System - CadoreSistemas"; Filename: "{app}\start_truckssystem.exe"
Name: "{commondesktop}\Trucks System - CadoreSistemas"; Filename: "{app}\start_truckssystem.exe"; Tasks: desktopicon

[Run]
Filename: "{app}\start_truckssystem.exe"; Description: "{cm:LaunchProgram,Trucks System - CadoreSistemas}"; Flags: nowait postinstall skipifsilent

