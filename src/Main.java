import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("FileRename");
        Main renameUtility = new Main();
        renameUtility.fileRename("E:\\Download");
    }

    private void fileRename(String folder) {
        File file = new File(folder);
        Scanner sc = new Scanner(System.in);
        System.out.println("Reading this " + file.toString());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            List<File> filelist = Arrays.asList(files);
            System.out.println("What name do you want to change or remove?");
            String nameFile = sc.nextLine();
            filelist.forEach(f -> {
                System.out.println("true - is Playback?");
                System.out.println("false - no is Playback");
                boolean isPlayback = sc.nextBoolean();
                if (!f.isDirectory() && f.getName().startsWith(nameFile) && isPlayback) {
                    System.out.println(f.getAbsolutePath());
                    String newName = f.getAbsolutePath().replace(nameFile, "Playback");
                    boolean isRenamed = f.renameTo(new File(newName));
                    if (isRenamed)
                        System.out.println(String.format("Renamed this file %s to  %s", f.getName(), newName));
                    else
                        System.out.println(String.format("%s file is not renamed to %s", f.getName(), newName));
                }else if (!f.isDirectory() && f.getName().startsWith(nameFile) && !isPlayback) {
                    System.out.println(f.getAbsolutePath());
                    String newName = f.getAbsolutePath().replace(nameFile, "").replace(" - ", "");
                    boolean isRenamed = f.renameTo(new File(newName));
                    if (isRenamed)
                        System.out.println(String.format("Renamed this file %s to  %s", f.getName(), newName));
                    else
                        System.out.println(String.format("%s file is not renamed to %s", f.getName(), newName));
                }
            });

        }
    }

    private void result(File f, String newName) {
        boolean isRenamed = f.renameTo(new File(newName));
        if (isRenamed)
            System.out.println(String.format("Renamed this file %s to  %s", f.getName(), newName));
        else
            System.out.println(String.format("%s file is not renamed to %s", f.getName(), newName));
    }
}

