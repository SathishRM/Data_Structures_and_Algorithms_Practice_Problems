/*
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Input: path = "/a/./b/../../c/"
Output: "/c"
 */
package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/..home//foo"));

    }

    public static String simplifyPath(String path) {

        Deque<String> pathNames = new ArrayDeque<>();
        StringBuilder curPath = new StringBuilder();
        StringBuilder curPeriod = new StringBuilder();

        for (int i=0;i<path.length();i++) {
            if(path.charAt(i) != '/' && path.charAt(i) != '.') {
                if(curPeriod.length() > 0) {
                    curPath.append(curPeriod);
                    curPeriod.setLength(0);
                }
                curPath.append(path.charAt(i));
            }

            if(path.charAt(i) == '.') {
                curPeriod.append('.');
            }

            if((i != 0 && path.charAt(i) == '/') || i == path.length() - 1) {
                if (curPeriod.length() > 2) {
                    pathNames.push(curPeriod.toString());
                }
                else if (curPeriod.length() == 2) {
                    if (pathNames.size() > 0){
                        pathNames.pop();
                    }
                }

                if (curPath.length() > 0) {
                    pathNames.push(curPath.toString());
                }
                curPath.setLength(0);
                curPeriod.setLength(0);
            }
        }
        curPath.setLength(0);
        while(pathNames.size() > 0) {
            curPath.append('/');
            curPath.append(pathNames.pollLast());
        }

        return curPath.length() <= 0 ? "/":curPath.toString();
    }
}
