class Solution {
    public String solution(String new_id) {
        //step 1
        new_id = new_id.toLowerCase();
        //step2
        char[] carr = new_id.toCharArray();
        for(int i=0; i<carr.length; i++){
            if((carr[i]>='a' && carr[i]<='z') ||(carr[i]>='0' && carr[i]<='9') || carr[i]=='-'|| carr[i]=='_'|| carr[i]=='.' ) continue;
            new_id = new_id.replace(String.valueOf(carr[i]), "");
        }
        //step3
        carr = new_id.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(new_id);
        for(int i=0; i<carr.length-1; i++) {
            if ( carr[i] == '.') {
                while (i<carr.length-1 && carr[++i] == '.') sb.setCharAt(i, '*');
            }
        }
        new_id = sb.toString();
        new_id = new_id.replace("*", "");
        //step4
        if(new_id.length() >=1 && new_id.charAt(0)=='.') new_id = new_id.substring(1,new_id.length());
        if(new_id.length() >=1 && new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0, new_id.length()-1);
        //step5
        if(new_id.length() == 0) new_id = "a";
        //step6
        if(new_id.length() >=16) new_id = new_id.substring(0, 15);
        if(new_id.length() >=1 && new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0, new_id.length()-1);
        //step7
        if(new_id.length()<=2){
            char tmp = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3) new_id = new_id.concat(String.valueOf(tmp));
        }

        return new_id; 
    }
}