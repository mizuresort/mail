import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);

        String from= readLine("差出人のアドレスを入力してください。",scanner);
        String to= readLine("受取人のアドレスを入力してください。",scanner);
        String subject= readLine("件名を入力してください。",scanner);
        String header= Mailer.makeHeader(from, to, subject);

        String body=readMultipleLines("送信するテキストを入力してください。",scanner);

        String mail=Mailer.makeMail(header, body);
        printMail(mail);

        for(int i=0; i<3; i++){
            System.out.println("返事を出します。");
            String originalBody=body;
            String originalFrom=from;

            from=to;
            to=originalFrom;
            subject=Mailer.makeReplySubject(subject);
            header=Mailer.makeHeader(from, to, subject);

            String reply=readMultipleLines("返信するテキストを入力してください。",scanner);
            body=Mailer.makeReplyBody(reply,originalFrom,originalBody);

            mail=Mailer.makeMail(header,body);
            printMail(mail);
        }
    
    } 
    
    static void printMail(String mail){
        System.out.println("\n====mail start=======");
        System.out.print(mail);
        System.out.println("====mail end=======\n");

    }

    static String readLine(String prompt, Scanner scanner){
       System.out.println(prompt);
       return scanner.nextLine();
    }

    static String readMultipleLines(String prompt, Scanner scanner){
        String inputEndString="END";
        System.out.println(prompt);
        System.out.println(inputEndString+"で終了");
        String text="";
        String line="";
        
        while (true) {
           line=scanner.nextLine();
           if(line.equals(inputEndString)){
            return text;
           } else{
            text+=line+"\n";
           }
        }
        }
    }
    

