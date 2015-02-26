package d.money.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import d.money.common.exception.SystemException;

/**
 * 类名称：FileUtil 文件操作共通类
 * 内容摘要：对于文件的共通操作
 * @version 1.0 2011-9-6
 */
public class FileUtil {

    /**
     * 新建文件
     * @param filePath 文件路径
     * @throws SystemException
     */
    public static void createFile(String filePath) throws SystemException {
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            throw new SystemException(e, "新建文件失败。");
        }

    }

    /**
     * 新建文件夹
     * @param filePath 文件路径
     */
    public static void createDir(String filePath) {
        File file = new File(filePath);
        file.mkdirs();
    }

    /**
     * 删除指定路径的文件
     * @param filePath 文件路径
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            file.delete();
        }
        else {
            deleteDir(file);
        }
    }

    /**
     * 递归删除目录所有内容
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            for (int i = 0; i < listFiles.length && deleteDir(listFiles[i]); i++) {
            }
        }
        return dir.delete();
    }

    /**
     * 文件拷贝
     * @param resourceFimeName 源文件的路径名称
     * @param targetFileName 目的文件的路径名称
     * @return
     * @throws IOException
     */
    public static boolean copyFile(String resourceFimeName, String targetFileName) throws IOException {

        return copyFile(new File(resourceFimeName), new File(targetFileName));
    }

    /**
     * 文件拷贝
     * @param resourceFimeName 源文件的路径名称
     * @param targetFile 目的文件
     * @return
     * @throws IOException
     */
    public static boolean copyFile(String resourceFimeName, File targetFile) throws IOException {
        return copyFile(new File(resourceFimeName), targetFile);
    }

    /**
     * 文件拷贝
     * @param resourceFile 源文件
     * @param targetFileName 目的文件的路径名称
     * @return
     * @throws IOException
     */
    public static boolean copyFile(File resourceFile, String targetFileName) throws IOException {
        return copyFile(resourceFile, new File(targetFileName));
    }

    /**
     * 文件拷贝
     * @param resourceFile 源文件
     * @param targetFile 目的文件
     * @return
     * @throws IOException
     */
    public static boolean copyFile(File resourceFile, File targetFile) throws IOException {
        if (resourceFile == null || targetFile == null)
            return false;

        if (resourceFile.exists()) {
            if (!targetFile.exists()) {
                File parentFile = targetFile.getParentFile();
                if (!parentFile.exists())
                    parentFile.mkdirs();
                targetFile.createNewFile();
            }
            FileInputStream in = new FileInputStream(resourceFile);
            FileOutputStream out = new FileOutputStream(targetFile);
            byte[] buffer = new byte[1024 * 8];
            int i = 0;

            while ((i = in.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            out.flush();
            in.close();
            out.close();
            return true;

        }
        else {
            return false;
        }
    }

}
