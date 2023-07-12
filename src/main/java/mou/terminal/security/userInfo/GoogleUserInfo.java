package mou.terminal.security.userInfo;

import java.util.Map;

public class GoogleUserInfo {

    private final Map<String,Object> attributes;

    public GoogleUserInfo(Map<String,Object> attributes){
        this.attributes = attributes;
    }

    public String getId(){
        return (String) attributes.get("sub");
     }

    public String getEmail(){
        return (String) attributes.get("email");
    }

    public String getPicture(){
        return (String) attributes.get("picture");
    }

}
