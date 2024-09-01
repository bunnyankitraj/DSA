package org.adaptor;

import org.adaptor.impl.AudioPlayer;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        //        MediaPlayer audioPlayer = new MediaPlayer() {
//            @Override
//            public void play(String audioType, String fileName) {
//
//            }
//        };

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi"); // This format is unsupported
    }
}
