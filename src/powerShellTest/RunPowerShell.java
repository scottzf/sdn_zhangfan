package powerShellTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunPowerShell {

	public static void main(String[] args) throws Exception {

		Runtime runtime = Runtime.getRuntime();

		 String cmds = (String)"cmd /C powershell D/hello.ps1";
		// String cmds = "powershell ipconfig";
//		String cmds1 = "powershell Enter-PSSession 172.20.44.20 -Credential dtop\\Dtop-AD"+"\r\n" + "ipconfig";
		
		Process proc = runtime.exec(cmds);
		
//		String cmds2 = "ipconfig";
//
//		proc = runtime.exec(cmds2);
		
		proc.getOutputStream().close();

		InputStream inputstream = proc.getInputStream();
		InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

		String line;
		while ((line = bufferedreader.readLine()) != null) {
			System.out.println(line);
		}

	}
}
