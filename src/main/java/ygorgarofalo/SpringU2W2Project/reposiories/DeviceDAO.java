package ygorgarofalo.SpringU2W2Project.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringU2W2Project.entities.Device;


@Repository
public interface DeviceDAO extends JpaRepository<Device, Long> {
}
