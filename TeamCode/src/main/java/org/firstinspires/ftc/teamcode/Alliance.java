package org.firstinspires.ftc.teamcode;

public class Alliance {
    //alliance needs to be non-static, but everything in this needs to be static

    public static enum alliance{
        RedAlliance,
        BlueAlliance
    };

    private static alliance currAlliance = null;

    public static void setAlliance(alliance inputAlliance){
        if(inputAlliance != null){
            currAlliance = inputAlliance;
        }
    }

    public static alliance getAlliance(){
        return currAlliance;
    }


}
