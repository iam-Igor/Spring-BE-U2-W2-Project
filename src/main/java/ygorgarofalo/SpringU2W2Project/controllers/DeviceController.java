package ygorgarofalo.SpringU2W2Project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ygorgarofalo.SpringU2W2Project.entities.Device;
import ygorgarofalo.SpringU2W2Project.exceptions.BadRequestExc;
import ygorgarofalo.SpringU2W2Project.payloads.DevicePayloadDTO;
import ygorgarofalo.SpringU2W2Project.responses.DeviceResponse;
import ygorgarofalo.SpringU2W2Project.services.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    // GET di tutti i devices sul db
    @GetMapping
    public Page<Device> getDevices(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String order) {
        return deviceService.getAllDevices(page, size, order);
    }


    //GET di un singolo device

    @GetMapping("/{id}")
    public Device getSingleDevice(@PathVariable long id) {

        return deviceService.findById(id);
    }


    //POST di un device, di default si crea il device senza associazione ad uno user,
// successivamente se si vuole associarne uno ad uno user si usa il secondo metodo post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponse saveDevice(DevicePayloadDTO payload, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestExc("Errori nel payload della richiesta");
        } else {
            Device newDevice = deviceService.saveDevice(payload);

            return new DeviceResponse(newDevice.getId());
        }


    }

}
