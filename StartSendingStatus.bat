@echo off
set /p id="Is Data Ready in Work Sheet?: "
D:
cd D:\Neon\AutomationWorkProcess-Part2
java -cp D:\Neon\AutomationWorkProcess-Part2\lib\*;D:\Neon\AutomationWorkProcess-Part2\bin org.testng.TestNG testng.xml
pause