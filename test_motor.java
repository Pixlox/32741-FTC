package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains a minimal example of a Linear "OpMode". An OpMode is a 'program' that runs
 * in either the autonomous or the TeleOp period of an FTC match. The names of OpModes appear on
 * the menu of the FTC Driver Station. When an selection is made from the menu, the corresponding
 * OpMode class is instantiated on the Robot Controller and executed.
 *
 * Remove the @Disabled annotation on the next line or two (if present) to add this OpMode to the
 * Driver Station OpMode list, or add a @Disabled annotation to prevent this OpMode from being
 * added to the Driver Station.
 */
@Autonomous

public class test_motor extends LinearOpMode {
    private Blinker control_Hub;
    private DcMotor test_motor;

    @Override
    public void runOpMode() {
        control_Hub = hardwareMap.get(Blinker.class, "Control Hub");
        test_motor = hardwareMap.get(DcMotor.class, "test_motor");
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

      
            // testing goBilda slides           
            test_motor.setPower(-1.0);
            telemetry.addData("Action", "Reverse for 2s");
            telemetry.update();
            sleep(1700); // 1700 ms = 1.7 seconds

            test_motor.setPower(1.0);
            telemetry.addData("Action", "Forward for 2s");
            telemetry.update();
            sleep(1700);

            test_motor.setPower(0);
            telemetry.addData("Action", "Stopped");
            telemetry.update();
            
            
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}
