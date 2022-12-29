package chap_07;

import chap_07.camera.ActionCam;
import chap_07.camera.SlowActionCam;

public class _17_final {
    public static void main(String[] args) {
        // final
        ActionCam actionCam = new ActionCam();
//        actionCam.lens = "표준렌즈";

        actionCam.recordVideo();
        actionCam.makeVideo();

        SlowActionCam slowActionCam = new SlowActionCam();
        slowActionCam.recordVideo();
        slowActionCam.makeVideo();
    }
}
