==============================WORDY READ ME (JAVA)==============================
To Set-up Java:
    1. Open 'zulu8.70.0.23-ca-jdk8.0.372-win_x64.msi'
       under Client_Installer\java8_jdk
    2. Click 'Next'
    3. Open the drop-down menu beside 'Set JAVA_HOME variable'
    4. Select either of the disk drive icons
    5. Proceed with the installation

To Generate Stubs:
    1. Run 'fall.cmd' to generate the server stub
    2. Run 'fclient.cmd' to generate the client stub

To Run Wordy:
    1. Execute the command 'start orbd -ORBInitialHost localhost -ORBInitialPort <server-port>'
       in command prompt OR run 'orbd.cmd'.
    2. Start WampServer and make sure it has 3 of 3 services.
    3. Server side:
            1. Modify Server_Java\src\WordyServer Run Configurations with this argument:
               -cp ..\lib\mysql-connector-j-8.0.32.jar;. -ORBInitialHost localhost -ORBInitialPort 1050
            2. Run WordyServer
            3. It should prompt:
               Database Connection Established!
               WordyServer ready and waiting ...
               Address: <server_address>
            4. Else, redo steps 1 and 2
        Client side:
            5. Modify Client_Java\src\WordyClientMain Run Configurations with this argument:
               -ORBInitialHost <server_address> -ORBInitialPort 1050
            6. Run WordyClientMain