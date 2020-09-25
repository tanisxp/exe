	start "Three tabs" "C:\dev\ConEmuPack.191012\ConEmu64.exe" /cmdlist ^> ^
	cmd -cur_console:d:C:\dev\tmp\mongodb\bin cmd /k mongod.exe  ^|^|^| ^
	cmd -cur_console:d:C:\dev\tmp\projects\backend-exe cmd /k mvn spring-boot:run ^|^|^| ^
	cmd -cur_console:d:C:\dev\tmp\projects\frontend-exe cmd /k npm run serve