cd /d %~dp0

set curWorkPath=%~dp0
set bullseyeResultPath=%COVFILE%
set trunkPath=%curWorkPath%\..\..\..\

pause

git pull

@echo StartTime:> startTime.txt
@echo %date%>> startTime.txt
@echo %time%>> startTime.txt

pause