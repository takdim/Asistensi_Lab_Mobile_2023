package com.example.tugas6;

import java.util.ArrayList;
import java.util.List;

public class DataChat {

    private static List<List<ModelBubble>>chats(){
        List<List<ModelBubble>>chats = new ArrayList<>();
        //orang
        List<ModelBubble>chat1= new ArrayList<>();
        chat1.add(new ModelBubble("Ayy","19.20", true));
        chat1.add(new ModelBubble("Ayyy","19.20", false));
        chat1.add(new ModelBubble("P","19.20", true));
        chat1.add(new ModelBubble("P","19.20", false));
        chat1.add(new ModelBubble("Lgi dimanaa?","19.21", false));

        chats.add(chat1);

        List<ModelBubble>chat2= new ArrayList<>();
        chat2.add(new ModelBubble("Weee","19.01", true));
        chat2.add(new ModelBubble("P","19.01", true));
        chat2.add(new ModelBubble("P","19.01", true));
        chat2.add(new ModelBubble("P","19.01", true));
        chat2.add(new ModelBubble("Loginn","19.01", false));

        chats.add(chat2);

        List<ModelBubble>chat3= new ArrayList<>();
        chat3.add(new ModelBubble("P","18.47", true));
        chat3.add(new ModelBubble("Log","18.47", true));
        chat3.add(new ModelBubble("Log","18.47", true));
        chat3.add(new ModelBubble("Log","18.47", true));
        chat3.add(new ModelBubble("Log bang","18.48", false));

        chats.add(chat3);

        List<ModelBubble>chat4= new ArrayList<>();
        chat4.add(new ModelBubble("Selvii","18.46", true));
        chat4.add(new ModelBubble("Dimana Ko","18.46", false));

        chats.add(chat4);

        List<ModelBubble>chat5= new ArrayList<>();
        chat5.add(new ModelBubble("Sherlok putee","18.45", true));
        chat5.add(new ModelBubble("Nnti sy kesitu","18.45", false));

        chats.add(chat5);

        List<ModelBubble>chat6= new ArrayList<>();
        chat6.add(new ModelBubble("Eh fit","18.30", true));
        chat6.add(new ModelBubble("Ready BO kahh?","18.31", false));

        chats.add(chat6);

        List<ModelBubble>chat7= new ArrayList<>();
        chat7.add(new ModelBubble("Rara","18.22", true));
        chat7.add(new ModelBubble("Sy ke Kost mu ini?","18.23", false));

        chats.add(chat7);

        List<ModelBubble>chat8= new ArrayList<>();
        chat8.add(new ModelBubble("ayu, kau dimana?","18.11", true));
        chat8.add(new ModelBubble("Bisa ko jemputka?","18.19", false));

        chats.add(chat8);

        List<ModelBubble>chat9= new ArrayList<>();
        chat9.add(new ModelBubble("Bah selesai ma","17.11", true));
        chat9.add(new ModelBubble("Tapi sebentar pi nah kukirim","17.11", false));
        chat9.add(new ModelBubble("Karena lagi diluar ka","17.11", false));

        chats.add(chat9);

        List<ModelBubble>chat10= new ArrayList<>();
        chat10.add(new ModelBubble("Tiya","16.43", true));
        chat10.add(new ModelBubble("Tiyaa","16.52", false));
        chat10.add(new ModelBubble("Ada mko disitu?","16.52", false));

        chats.add(chat10);

        List<ModelBubble>chat11= new ArrayList<>();
        chat11.add(new ModelBubble("Siapa?","16.43", true));
        chat11.add(new ModelBubble("Saya Orang Kesepuluh","16.52", false));

        chats.add(chat11);

        List<ModelBubble>chat12= new ArrayList<>();
        chat12.add(new ModelBubble("Siapa?","16.43", true));
        chat12.add(new ModelBubble("Saya Orang Kesepuluh","16.52", false));

        chats.add(chat12);

        List<ModelBubble>chat13= new ArrayList<>();
        chat13.add(new ModelBubble("Siapa?","16.43", true));
        chat13.add(new ModelBubble("Saya Orang Kesepuluh","16.52", false));

        chats.add(chat13);

        List<ModelBubble>chat14= new ArrayList<>();
        chat14.add(new ModelBubble("Siapa?","16.43", true));
        chat14.add(new ModelBubble("Saya Orang Kesepuluh","16.52", false));

        chats.add(chat14);

        List<ModelBubble>chat15= new ArrayList<>();
        chat15.add(new ModelBubble("Siapa?","16.43", true));
        chat15.add(new ModelBubble("Saya Orang Kesepuluh","16.52", false));

        chats.add(chat15);



        return chats;
    }

    public static ArrayList<ModelChat>
    ambilDataChat() {
        ArrayList<ModelChat> dataChat = new ArrayList<>();
        dataChat.add(new ModelChat("Raa ❤",chats().get(0), "https://i.ibb.co/9H19CFd/1681291817136.jpg%22", "08234220109", "Bii❤", "19.21"));
        dataChat.add(new ModelChat("Ocang", chats().get(1), "https://i.ibb.co/2hH9bqg/ocang.jpg%22", "081341070723", "Panggilan mendesak aja", "19.01"));
        dataChat.add(new ModelChat("Rahmat", chats().get(2), "https://i.ibb.co/2W8RZ9G/1681293674086.jpg%22", "085340061341", "Sibuk", "20.08"));
        dataChat.add(new ModelChat("Selfii", chats().get(3), "https://i.ibb.co/q7RnHJT/Selfi.jpg%22", "0815409213490", "Ada", "20.02"));
        dataChat.add(new ModelChat("Putee", chats().get(4), "https://i.ibb.co/BGDQ03t/Putee.jpg%22", "085852019642", "Jaga Hati", "01.12"));
        dataChat.add(new ModelChat("Fitrii", chats().get(5), "https://i.ibb.co/BwgcfNT/Fitri.jpg%22", "082809847367", "BoMatt", "Kemarin 13.20"));
        dataChat.add(new ModelChat("Rara", chats().get(6), "https://i.ibb.co/QmVdGp8/Rara.jpg%22", "089129376642", "Ready BO", "21.20"));
        dataChat.add(new ModelChat("Ayuu", chats().get(7), "https://i.ibb.co/xhSw7Bk/Ayu.jpg%22", "081120944362", "Menunggu", "30 Feb 2023"));
        dataChat.add(new ModelChat("Mandaa", chats().get(8), "https://i.ibb.co/R6FSH21/Manda.jpg%22", "088123456145", "Belajar lebih baik", "10.09"));
        dataChat.add(new ModelChat("Tiyaa", chats().get(9), "https://i.ibb.co/NNXw48p/tiya.jpg%22", "082937122338", "Sibuk", "Recently"));
        dataChat.add(new ModelChat("Yulii", chats().get(10), "https://i.ibb.co/W30pgym/Yuli.jpg%22", "081398748832", "Ada nihh", "Recently"));
        dataChat.add(new ModelChat("Nay", chats().get(11), "https://i.ibb.co/G7q093R/Naya.jpg%22", "085242378021", "Haloo", "Recently"));
        dataChat.add(new ModelChat("Bilaa", chats().get(12), "https://i.ibb.co/vsPq9GD/Bilaa.jpg%22", "089883772110", "Sedang rapat", "Recently"));
        dataChat.add(new ModelChat("Anty", chats().get(13), "https://i.ibb.co/yXqPVhY/Anty.jpg%22", "082230098912", "Adakahh", "Recently"));
        return dataChat;


    }
}

