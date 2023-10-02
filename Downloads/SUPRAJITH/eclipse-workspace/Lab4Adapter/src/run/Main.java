package run;

interface MediaPlayer {
    void play();
}

interface AdvancedMediaPlayer {
    void playMedia(String filename);
}

class Mp3Player implements MediaPlayer {
    public void play() {
        System.out.println("Playing Mp3 media");
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playMedia(String filename) {
        System.out.println("Playing media from " + filename + " using MP4 Player");
    }
}

class VLCPlayer implements AdvancedMediaPlayer {
    public void playMedia(String filename) {
        System.out.println("Playing media from " + filename + " using VLC Player");
    }
}

class MediaPlayerAdapter implements AdvancedMediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void playMedia(String filename) {
        System.out.print("\nPlaying from adapter: ");
        advancedMediaPlayer.playMedia(filename);
    }
}

public class Main {
    public static void main(String[] args) {
        MediaPlayer mp3Player = new Mp3Player();
        mp3Player.play();

        AdvancedMediaPlayer mp4Player = new MediaPlayerAdapter(new Mp4Player());
        mp4Player.playMedia("Speech.mp4");

        mp4Player = new MediaPlayerAdapter(new VLCPlayer());
        mp4Player.playMedia("Oppenheimer BluRay 4K.mp4");
    }
}
