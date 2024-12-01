import greenfoot.*;

public class SoundManager
{
    private static boolean isMuted = false; 
    private static GreenfootSound backgroundMusic;
    private static GreenfootSound keyCollectSound;  
    private static GreenfootSound gameWonSound; 
    private static GreenfootSound gameLostSound;  
    private static GreenfootSound gunCollectedSound; 
    private static GreenfootSound shootGarlic; 
    public static void initialize(GreenfootSound bgMusic, GreenfootSound keySound, GreenfootSound wonSound, GreenfootSound lostSound,  GreenfootSound gunSound, GreenfootSound garlicSound)
    {
        backgroundMusic = bgMusic;  
        keyCollectSound = keySound;  
        gameWonSound = wonSound;  
        gameLostSound = lostSound;
        gunCollectedSound = gunSound;
        shootGarlic = garlicSound;
    }
    public static void playBackgroundMusic()
    {
        if (backgroundMusic != null && !backgroundMusic.isPlaying() && !isMuted)
        {
            backgroundMusic.playLoop();  
        }
    }
    public static void stopBackgroundMusic()
    {
        if (backgroundMusic != null && backgroundMusic.isPlaying())
        {
            backgroundMusic.pause(); 
        }
    }
    public static void toggleSound()
    {
        isMuted = !isMuted;  
        if (isMuted)
        {
            stopBackgroundMusic();  // Pause music when muted
            if (keyCollectSound != null && keyCollectSound.isPlaying()) {
                keyCollectSound.pause();
            }
            if (gameWonSound != null && gameWonSound.isPlaying()) {
                gameWonSound.pause();
            }
            if (gameLostSound != null && gameLostSound.isPlaying()) {
                gameLostSound.pause();
            }
            if (gunCollectedSound != null && gunCollectedSound.isPlaying()) {
                gunCollectedSound.pause();
            }
            if (shootGarlic != null && shootGarlic.isPlaying()) {
                shootGarlic.pause();
            }
        }
        else
        {
            playBackgroundMusic();  // Resume playing background music
        }
    }
    public static boolean isMuted()
    {
        return isMuted;
    }
    public static void playKeyCollectSound()
    {
        if (!isMuted && keyCollectSound != null)
        {
            keyCollectSound.play();  // Play the sound when the key is collected
        }
    }public static void playGunCollectSound()
    {
        if (!isMuted && gunCollectedSound != null)
        {
            gunCollectedSound.play();  // Play the sound when the key is collected
        }
    }
    public static void playGameWonSound()
    {
        if (!isMuted && gameWonSound != null)
        {
            gameWonSound.play();  // Play the sound when the game is won
        }
    }
    public static void playGameLostSound()
    {
        if (!isMuted && gameLostSound != null)
        {
            gameLostSound.play();  // Play the sound when the game is won
        }
    }
    public static void playshootGarlic()
    {
        if (!isMuted && shootGarlic != null)
        {
            shootGarlic.play();  // Play the sound when the game is won
        }
    }
}
