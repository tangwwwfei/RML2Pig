/*
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.tests

import com.google.inject.Inject
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.xtext.example.rml.generator.IRMLGenerator
import org.xtext.example.rml.iRML.Mapping
import java.io.FileWriter

@ExtendWith(InjectionExtension)
@InjectWith(IRMLInjectorProvider)
class IRMLParsingTest {
	@Inject
	ParseHelper<Mapping> parseHelper
	
	@Test
	def void loadModel() {
		var filelist = new ArrayList<File>()
		getFileList(filelist, "../org.xtext.example.rml/test/resources")
		for (file : filelist) {
			var filepath = file.getPath()
			val result = parseHelper.parse(readFile(filepath))
			if (result !== null) {
				var errors = result.eResource.errors
				if (errors.isEmpty()) {
					print("Inspect:" + filepath + "\r\n")
					val fsa = new InMemoryFileSystemAccess()//new InMemoryFileSystemAccess()
        			new IRMLGenerator().doGenerate(result.eResource, fsa, null)
        			var files = fsa.getAllFiles()
        			var keys = files.keySet()
        			for	(key : keys) {
        				var writer = new FileWriter(filepath+".xmi", false)
        				writer.write(files.get(key) as String)
        				writer.close()
        			}
        			//Assertions.assertNotNull(null)
				}
				else{
					System.err.print("Inspect:" + filepath + "\r\n")
				}
				for (error : errors) {
					print(error + "\r\n")
				}
				Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
			}
			else{
				System.err.print("Inspect:" + filepath + "\r\n")
				//Assertions.assertNotNull(result)
			}
		}
	}
	
	def String readFile(String filePath){
		var buffer = new StringBuffer()
        var is = new FileInputStream(filePath);
        var reader = new BufferedReader(new InputStreamReader(is));
        var line = reader.readLine(); // 读取第一行
        while (line !== null) {
            buffer.append(line);
            buffer.append("\r\n");
            line = reader.readLine();
        }
        reader.close();
        is.close();
        return buffer.toString()
    }
    
	def void getFileList(List<File> filelist, String strPath) {
		var dir = new File(strPath);
		var files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files !== null) {
			for (file : files) {
				var fileName = file.getName();
				if (file.isDirectory()) { // 判断是文件还是文件夹
					getFileList(filelist, file.getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith(".ttl") && !fileName.endsWith("output.ttl") && !fileName.endsWith(".out.ttl")
					&& !fileName.endsWith(".metadata.ttl") && !fileName.startsWith("resource")
				) { // 判断文件名是否以.avi结尾
					//var strFileName = file.getAbsolutePath();
					filelist.add(file);
				}
			}
		}
	}
}
