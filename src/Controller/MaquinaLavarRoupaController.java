package Controller;

import java.util.List;

import entities.MaquinaLavarRoupa;
import service.maquinaLavarRoupa.CreateMaquinaLavarRoupaService;
import service.maquinaLavarRoupa.DeleteMaquinaLavarRoupaService;
import service.maquinaLavarRoupa.ReadMaquinaLavarRoupaService;
import service.maquinaLavarRoupa.UpdateMaquinaLavarRoupaService;

public class MaquinaLavarRoupaController {
    private CreateMaquinaLavarRoupaService createMaquinaLavarRoupaService;
    private ReadMaquinaLavarRoupaService readMaquinaLavarRoupaService;
    private UpdateMaquinaLavarRoupaService updateMaquinaLavarRoupaService;
    private DeleteMaquinaLavarRoupaService deleteMaquinaLavarRoupaService;

    public MaquinaLavarRoupaController(){
        this.createMaquinaLavarRoupaService = new CreateMaquinaLavarRoupaService();
        this.readMaquinaLavarRoupaService = new ReadMaquinaLavarRoupaService();
        this.updateMaquinaLavarRoupaService = new UpdateMaquinaLavarRoupaService();
        this.deleteMaquinaLavarRoupaService = new DeleteMaquinaLavarRoupaService();
    }

    public String handleCreateMaquinaLavarRoupa(MaquinaLavarRoupa maquinaLavarRoupa){
        String result = this.createMaquinaLavarRoupaService.create(maquinaLavarRoupa);
        return result;
    }

    public List<MaquinaLavarRoupa> handleReadMaquinaLavarRoupa(){
        List<MaquinaLavarRoupa> result = this.readMaquinaLavarRoupaService.read();
        return result;
    }

    public String handleUpdateMaquinaLavarRoupa(MaquinaLavarRoupa maquinaLavarRoupa, String idMaquinaLavarRoupa){
        String result = this.updateMaquinaLavarRoupaService.update(maquinaLavarRoupa, idMaquinaLavarRoupa);
        return result;
    }

    public String handleDeleteMaquinaLavarRoupa(String idMaquinaLavarRoupa){
        String result = this.deleteMaquinaLavarRoupaService.delete(idMaquinaLavarRoupa);
        return result;
    }
}
