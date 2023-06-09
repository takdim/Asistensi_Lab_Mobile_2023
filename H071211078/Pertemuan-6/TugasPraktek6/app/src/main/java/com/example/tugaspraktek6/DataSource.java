package com.example.tugaspraktek6;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Profile> profiles = generateDummyProfiles();
    public static ArrayList<Post> posts = generateDummyPosts();

    private static ArrayList<Profile> generateDummyProfiles() {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Caelus", "Trailblazer (Male)",  "https://media-assets-ggwp.s3.ap-southeast-1.amazonaws.com/2023/05/caelus-physical-patch-1.0-featured-640x360.jpg"));
        profiles.add(new Profile("Stelle", "Trailblazer (Female)", "https://images2.alphacoders.com/131/1313467.png"));
        profiles.add(new Profile("March 7th", "Self-proclaimed bishoujo", "https://images2.alphacoders.com/131/1314652.jpeg"));
        profiles.add(new Profile("Dan Heng", "Silent guy with mysterious past", "https://images.alphacoders.com/131/1313460.jpg"));
        profiles.add(new Profile("Himeko", "You're as beautiful as the day I lost you","https://images5.alphacoders.com/131/1314656.jpg"));
        profiles.add(new Profile("Welt", "You're finally playable, FINALLY","https://images5.alphacoders.com/131/1315682.jpg"));
        profiles.add(new Profile("Bronya", "Zaychik or Rand, idk",  "https://images5.alphacoders.com/131/1315685.jpg"));
        profiles.add(new Profile("Seele","Zee-re, not Zeela", "https://images4.alphacoders.com/126/1268981.png"));
        profiles.add(new Profile("Kafka", "Mommy, sorry, mommy sorry", "https://images4.alphacoders.com/131/1313457.jpg"));
        profiles.add(new Profile("Silver Wolf","Residential Hacker", "https://images4.alphacoders.com/131/1313652.jpg"));
        return profiles;
    }

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Caelus", "Trailblazer (Male)", "https://media-assets-ggwp.s3.ap-southeast-1.amazonaws.com/2023/05/caelus-physical-patch-1.0-featured-640x360.jpg", "I suspect him to be a racoon during his past life", "https://media-assets-ggwp.s3.ap-southeast-1.amazonaws.com/2023/05/caelus-physical-patch-1.0-featured-640x360.jpg"));
        posts.add(new Post("Stelle", "Trailblazer (Female)", "https://images2.alphacoders.com/131/1313467.png", "I suspect her to be a racoon during his past life", "https://images2.alphacoders.com/131/1313467.png"));
        posts.add(new Post("March 7th", "Self-proclaimed bishoujo", "https://images2.alphacoders.com/131/1314652.jpeg", "Her powers run parallel with her personality", "https://images2.alphacoders.com/131/1314652.jpeg"));
        posts.add(new Post("Dan Heng", "Silent guy with mysterious past", "https://images.alphacoders.com/131/1313460.jpg", "Knowledgeable, definitely has a mysterious past trope", "https://images.alphacoders.com/131/1313460.jpg"));
        posts.add(new Post("Himeko", "You're as beautiful as the day I lost you", "https://images5.alphacoders.com/131/1314656.jpg", "Never, I mean NEVER badmouth her coffee", "https://images5.alphacoders.com/131/1314656.jpg"));
        posts.add(new Post("Welt", "You're finally playable, FINALLY", "https://images5.alphacoders.com/131/1315682.jpg", "You have no idea how OP this guy before the events of HI3", "https://images5.alphacoders.com/131/1315682.jpg"));
        posts.add(new Post("Bronya", "Zaychik or Rand, idk", "https://images5.alphacoders.com/131/1315685.jpg", "In whichever world, you're still beautiful", "https://images5.alphacoders.com/131/1315685.jpg"));
        posts.add(new Post("Seele", "Zee-re, not Zeela", "https://images4.alphacoders.com/126/1268981.png", "I know her name is german, I just don't give a damn", "https://images4.alphacoders.com/126/1268981.png"));
        posts.add(new Post("Kafka", "Mommy, sorry, mommy sorry", "https://images4.alphacoders.com/131/1313457.jpg", "STEP ON ME, I-I mean Stop right there!", "https://images4.alphacoders.com/131/1313457.jpg"));
        posts.add(new Post("Silver Wolf", "Residential Hacker", "https://images4.alphacoders.com/131/1313652.jpg", "Haven't I met you before somewhere else ?", "https://images4.alphacoders.com/131/1313652.jpg"));
        return posts;
    }
}
