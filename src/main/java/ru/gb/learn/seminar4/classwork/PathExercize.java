package ru.gb.learn.seminar4.classwork;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

public class PathExercize
{
    public static void main (String[] args)
    {
        System.out.println ("simplifyPath (\"///foo//bar/\") = " + simplifyPath ("///foo//bar/"));
        System.out.println ("simplifyPath (\"..\") = " + simplifyPath (".."));
        System.out.println ("simplifyPath (\"/../\") = " + simplifyPath ("/../"));
        System.out.println ("simplifyPath (\"/home/foo//..///bar\") = " + simplifyPath ("/home/foo//..///bar"));
    }
    
    /**
     * @param path исходное значение пути
     * @return результирующее значение
     * @apiNote возвращает каноническое представление пути к директории или файлу
     */
    private static String simplifyPath (String path)
    {
        String[] subPaths = path.split ("/+");
        Deque <String> pathList = new LinkedList <> ();
        for (int i = subPaths[0].equals ("") ? 1 : 0; i < subPaths.length; i++)
        {
            String s = subPaths[i];
            if (s.equals (".."))
            {
                if (!pathList.isEmpty ()) pathList.pollLast ();
            }
            else if (!s.equals (".")) pathList.add (s);
        }
        
        StringJoiner joiner = new StringJoiner ("/", "/", "");
        for (String s : pathList) joiner.add (s);
        return joiner.toString ();
    }
}
