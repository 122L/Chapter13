package lessonOnePointFive;

public class LoopingMediaLib {
    public static void main(String[] args) {
        String s = MediaFile.readString();
        //while (s != null)
            //String title = s.substring(0, s.indexOf("|"));
            //System.out.println("Title: " + title);
            //String rating = s.substring(s.indexOf("|"), s.length());
            //System.out.println("Rating: " + rating + "|");
            //s = MediaFile.readString();
        while(s != null) {
            int rating = Integer.parseInt(s.substring(s.indexOf("|") + 1));
            if (rating >= 9) {
                String title = s.substring(0, s.indexOf("|"));
                System.out.println("Title: " + title);
                System.out.println("Rating: " + rating);
                s = MediaFile.readString();
                    }
                }
            }
        }
