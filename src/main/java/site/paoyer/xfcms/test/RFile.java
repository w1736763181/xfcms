package site.paoyer.xfcms.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RFile {
    public static void main(String[] args) {
        try {
            Map<String, String> repStr = new HashMap<>();
            repStr.put("11.壁橱", "011壁橱");
            repStr.put("18.通用大样图-浴缸", "018通用大样图-浴缸");

            Collection<File>  files = FileUtils.listFiles(new File("/workspace/yaml/hengda/"), new String[]{"yaml"}, true);
            for(File file: files) {
                System.out.println(file.getAbsolutePath());
                rFileConrtent(file, repStr);
                //            rFileConrtent(, "11.壁橱", "011壁橱");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rFileConrtent(File file, Map<String, String> repStr) throws IOException {
        String newstr = FileUtils.readFileToString(file);
        for(String key : repStr.keySet()) {
            newstr = newstr.replace(key, repStr.get(key));
        }
        FileUtils.write(file, newstr);
    }
}
