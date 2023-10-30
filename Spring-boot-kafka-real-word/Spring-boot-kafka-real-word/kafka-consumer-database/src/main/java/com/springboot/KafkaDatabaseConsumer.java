package com.springboot;

import com.springboot.entity.WikiMediaData;
import com.springboot.repository.WikiMediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    public static Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikiMediaDataRepository wikiMediaDataRepository;

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info("Event message received :: "+eventMessage);

        WikiMediaData data = new WikiMediaData();
        data.setWikiEventData(eventMessage);
        wikiMediaDataRepository.save(data);
    }


//    private String tempEventMessage(){
//        return "{\"$schema\":\"/mediawiki/recentchange/1.0.0\",\"meta\":{\"uri\":\"https://commons.wikimedia.org/wiki/File:Barcelona_-_Estaci%C3%B3_de_Fran%C3%A7a_(7495457834).jpg\",\"request_id\":\"0c424bd2-cc8a-46b1-909c-672c477670f2\",\"id\":\"50257ea6-c4cc-4c29-b9a3-4573cf5d4fee\",\"dt\":\"2023-10-30T17:44:24Z\",\"domain\":\"commons.wikimedia.org\",\"stream\":\"mediawiki.recentchange\",\"topic\":\"codfw.mediawiki.recentchange\",\"partition\":0,\"offset\":727961146},\"id\":2341430602,\"type\":\"edit\",\"namespace\":6,\"title\":\"File:Barcelona - Estació de França (7495457834).jpg\",\"title_url\":\"https://commons.wikimedia.org/wiki/File:Barcelona_-_Estaci%C3%B3_de_Fran%C3%A7a_(7495457834).jpg\",\"comment\":\"/* wbeditentity-update:0| */ automatically adding [[Commons:Structured data|structured data]] based on file information\",\"timestamp\":1698687864,\"user\":\"SchlurcherBot\",\"bot\":true,\"notify_url\":\"https://commons.wikimedia.org/w/index.php?diff=816948461&oldid=762452093&rcid=2341430602\",\"minor\":false,\"patrolled\":true,\"length\":{\"old\":5384,\"new\":7408},\"revision\":{\"old\":762452093,\"new\":816948461},\"server_url\":\"https://commons.wikimedia.org\",\"server_name\":\"commons.wikimedia.org\",\"server_script_path\":\"/w\",\"wiki\":\"commonswiki\",\"parsedcomment\":\"\u200E<span dir=\\\"auto\\\"><span class=\\\"autocomment\\\">Changed an entity: </span></span> automatically adding <a href=\\\"/wiki/Commons:Structured_data\\\" title=\\\"Commons:Structured data\\\">structured data</a> based on file information\"}\n";
//    }
}
