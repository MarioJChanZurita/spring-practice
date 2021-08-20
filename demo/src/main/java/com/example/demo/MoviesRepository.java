package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String> {

}
    

/* @Document(collection = "Info")
public class Info  {

  @Id
  private String id;
  
  private Integer count;
  
  private String type;
  
  // other fields and getters and setters
}

public interface InfoRepository extends MongoRepository<Info, String> {

    @Query(value="{ 'count' : 0, 'type' : 'binary' }", fields="{ 'id' : 1 }")
    List<Info> getInfo();
  
 }


 @Service
public class InfoService {

   @Autowired 
   private InfoRepository infoRepository;

   public List<String> getIds() {
   
      return infoRepository.getInfo()
                      .stream()
                      .map(Info::getId)
                      .collect(Collectors.toList());    

   }

}
 */