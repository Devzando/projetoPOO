package service.maquinaLavarRoupa;

import java.util.List;

import entities.MaquinaLavarRoupa;
import repositoryImplements.maquinaLavarRoupa.MaquinaLavarRoupaRepository;

public class ReadMaquinaLavarRoupaService {
     private MaquinaLavarRoupaRepository maquinaLavarRoupaRepository;

     public ReadMaquinaLavarRoupaService(){
         this.maquinaLavarRoupaRepository = new MaquinaLavarRoupaRepository();
     }

     public List<MaquinaLavarRoupa> read(){
        List<MaquinaLavarRoupa> result = this.maquinaLavarRoupaRepository.read();

        return result;
    }
}
