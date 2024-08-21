package org.example;

public class Point3 {
    private static final int CHARS_IN_PAGE = 1800;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final String FILE_PATH = "java3-task3/src/main/resources";

    private static void readAndPrintByteArray() {

        try (final InputStream fin = new FileInputStream(FILE_PATH + "/50byte.txt");
             final ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {

            final byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
            int len;

            while ((len = fin.read(buf)) != -1) {
                bytes.write(buf, 0, len);
            }

            System.out.println(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void merge() {
        SequenceInputStream seq;
        ArrayList<InputStream> al = new ArrayList<>();
        FileOutputStream out;

        try {
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));

            out = new FileOutputStream(FILE_PATH + "/concat.txt");

            Enumeration<InputStream> e = Collections.enumeration(al);

            seq = new SequenceInputStream(e);

            try {
                int rb = seq.read();

                while (rb != -1) {
                    out.write(rb);
                    rb = seq.read();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void cliPageReader() {

        try (InputStream in = new FileInputStream(FILE_PATH + "/10mb.txt");
             ByteArrayOutputStream book = new ByteArrayOutputStream()) {

            byte[] buff = new byte[CHARS_IN_PAGE];
            int len;

            while ((len = in.read(buff)) > 0) {
                book.write(buff, 0, len);
            }

            int page;
            int numberOfPages = book.size() / CHARS_IN_PAGE;
            int pages;
            int enterPage;
            int offset;
            int turnThePages;

            Scanner input = new Scanner(System.in);

            while (true) {
                pages = numberOfPages;

                do {
                    System.out.printf("%n%nplease enter the page: 1 - %d%n", pages + 1);
                    page = input.nextInt();
                } while (page < 1 && page < pages);

                enterPage = page;
                offset = (enterPage - 1) * CHARS_IN_PAGE;
                turnThePages = offset + CHARS_IN_PAGE;

                byte[] bytes = book.toByteArray();
                len = bytes.length;

                while (offset != turnThePages && offset < len) {
                    System.out.print((char) bytes[offset]);
                    offset++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        readAndPrintByteArray();
    }
}
