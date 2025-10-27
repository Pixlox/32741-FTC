package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Dual Motor Joystick Control", group = "Linear Opmode")
public class DualMotorJoystickControl extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;

    @Override
    public void runOpMode() {

        // Motors mapped on Driver Station
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");

        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor2.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized - Waiting for start");
        telemetry.update();

        // Wait for the driver to press PLAY
        waitForStart();

        while (opModeIsActive()) {

            // reading off controller - y axis is inverted on gamepads, so we flip
            double drive = -gamepad1.left_stick_y;

            // Apply controller value directly
            motor1.setPower(drive);
            motor2.setPower(drive);

            // Debugging telemetry
            telemetry.addData("Joystick Y", gamepad1.left_stick_y);
            telemetry.addData("Motor Power", drive);
            telemetry.update();
        }
    }
}
