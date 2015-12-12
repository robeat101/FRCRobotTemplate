package competition.subsystems.sensor;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import xbot.common.command.BaseSubsystem;
import xbot.common.controls.sensors.XInertialMeasurementUnit;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.common.properties.PropertyManager;

/**
 *
 */
@Singleton
public class ValidateIMUSubsystem extends BaseSubsystem {

    public final XInertialMeasurementUnit orientationUnit;

    private static Logger log = Logger.getLogger(ValidateIMUSubsystem.class);

    @Inject
    public ValidateIMUSubsystem(WPIFactory factory, PropertyManager propManager)
    {    
        log.debug("Initializing ValidateIMUSubsystem");
        this.orientationUnit = factory.getIMU();
    }

    /**
     * Display navX-MXP Sensor Data on Smart dashboard
     */
    public void updateDashboard() {

        /* Display 6-axis Processed Angle Data */
        SmartDashboard.putBoolean("IMU_Connected", orientationUnit.isConnected());
        SmartDashboard.putNumber("IMU_Yaw", orientationUnit.getYaw());
        SmartDashboard.putNumber("IMU_Pitch", orientationUnit.getPitch());
        SmartDashboard.putNumber("IMU_Roll", orientationUnit.getRoll());
    }
}
