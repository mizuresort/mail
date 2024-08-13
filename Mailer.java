public class Mailer {
    static String makeReplySubject(String subject){
        if(subject.startsWith("Re: ")){
            return subject;
        }else{
            return "Re: "+subject;
        }
    }

    static String makeHeader(String from, String to, String subject){
        String fromLine="From: "+from+"\n";
        String toLine="To: "+to+"\n";
        String subjectLine="Subject: "+subject+"\n";
        String header=fromLine+toLine+subjectLine;
        return header;
    }

    static String makeMail(String header, String body){
        String mail=header+"\n"+body;
        return mail;
    }

    static String makeReplyBody(String body, String originalFrom, String originalBody){
        String quoteOriginalBody=makeQuoteText(originalBody);
        String replyBody=body+originalFrom+" wrote: \n"+quoteOriginalBody;
        return replyBody;
    }

    static String makeQuoteText(String text){
        String[] lines=text.split("\n");
        String quoteText="";
        for(int i=0; i<lines.length; i++){
            quoteText+="> "+ lines[i]+"\n";
        }
        return quoteText;
    }
}
