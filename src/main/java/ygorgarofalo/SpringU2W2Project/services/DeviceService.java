package ygorgarofalo.SpringU2W2Project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringU2W2Project.entities.Device;
import ygorgarofalo.SpringU2W2Project.reposiories.DeviceDAO;

@Service
public class DeviceService {


    @Autowired
    private DeviceDAO deviceDAO;


    // metodo associato al get /devices
    public Page<Device> getAllDevices(int page, int size, String order) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(order));
        return deviceDAO.findAll(pageable);
    }
}
