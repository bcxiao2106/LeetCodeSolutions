package String;

import java.io.File;
import java.util.HashMap;

public class LongestAbsoluteFilePath {

	public static int lengthLongestPath(String input) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		StringBuilder sb = new StringBuilder(input);
        String[] lines = input.split("\\n");
        StringBuilder pathStr = new StringBuilder();
        int tabCount = 0;
        for(String line : lines){
        	tabCount = line.lastIndexOf('\t');
        	String clearString = line.replaceAll("\\t", "");
        	hm.put(tabCount, clearString);
        }
		return 1;
    }
}
