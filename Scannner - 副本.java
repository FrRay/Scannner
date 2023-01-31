/**                                                                                                                                      
* @code quickly                                                                                                                          
* @author FYL                                                                                                                            
* @date 2022年12月13日15:12:46
                                                                                      
*/

package javax.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Scannner {
	// 存放代码文件夹的路径（默认）
	String pathString = "D:/develop/Java/aport/javaw.util.Scanner";

	public String[] qwnames;
	public Map<String, String> qwtexts = new HashMap<String, String>();

	// 构造方法，load all code
	public void readfile(String path) {

		try {

			File file = new File(pathString);

			if (file.isDirectory()) {
				// 获取文件夹下所有子文件的文件名，得到一个str array
				qwnames = file.list();
				// 遍历数组，将每个文件名作为key、每个文件中的内容作为value，放到（Map<String, String>）qwtexts
				for (int i = 0; i < qwnames.length; i++) {

					File readFilePath = new File(pathString + "/" + qwnames[i]);

					StringBuffer qwtext = new StringBuffer();
					{
						String tempString = null;

						BufferedReader reader = new BufferedReader(new FileReader(readFilePath));
						while ((tempString = reader.readLine()) != null) {
							qwtext.append(tempString + "\n");
						}
						reader.close();

					}
					if (qwtext != null) {
						// System.out.println("正在 " + qwnames[i]);
						// System.out.println(qwtext.toString());
						qwtexts.put(qwnames[i], qwtext.toString());
					}

				}
			}

		} catch (Exception e) {
			System.out.println("error at loading");
		}
	}

	// 根据关键字查询
	public void nextLnt() {

		try {
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) { // 一直循环，程序不结束
				boolean isfind = false;
				String need = scanner.next();// 模拟模糊查询
				for (String s : qwnames) {

					if (s.contains(need)) {
						isfind = true;
						String needtext = qwtexts.get(s);
						// 核心功能代码：将名为needtext的字符串放到剪切板
						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(needtext),
								null);

						break;
					}

				}
				// 相应3个回车符，试图掩饰
				System.out.println("\n\n\n");
				Thread.currentThread();
				Thread.sleep(2500);
				if (isfind) {
					// 成功查询就输出“y”
					System.out.println("y\n\n\n ");
				} else {
					// 查不到输出“n”
					System.out.println("n\n\n\n");
				}
			}
			scanner.close();

		} catch (Exception e) {
			System.out.println("error at nextLnt");
		}
	}

	// 根据大写首字母查询，跟上面方法的类似
	public void hasNext() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) { // 一直循环，程序不结束

				boolean isfind = false;
				String need = scanner.next();// 模拟模糊查询

				for (String s : qwnames) {

					String upCaseString = "";
					String lowCaseString = "";
					for (int i = 0; i < s.length(); i++) {
						char c = s.charAt(i);
						if (c >= 'A' && c <= 'Z') {
							upCaseString += c;
						}
					}
					lowCaseString = upCaseString.toLowerCase();

					if (lowCaseString.contains(need) || upCaseString.contains(need)) {
						isfind = true;
						String needtext = qwtexts.get(s);

						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(needtext),
								null);
						break;
					}

				}
				System.out.println("\n\n\n");
				Thread.currentThread();
				Thread.sleep(2500);
				if (isfind) {
					System.out.println("y\n\n\n ");
				} else {
					System.out.println("n\n\n\n");
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("error at hasNext");
		}
	}

	// Default Path
	public Scannner() {
		this.readfile(pathString);
	}

	// Userdefined path
	public Scannner(String userdefinedPath) {
		if (path != null && path.length() != 0) {
			this.readfile(userdefinedPath);
		} else {
			this.readfile(pathString);
		}
	}
}
