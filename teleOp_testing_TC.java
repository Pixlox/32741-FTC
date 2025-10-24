package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Tank Drive - Two Motors", group = "Linear Opmode")
public class TankDriveTwoMotors extends LinearOpMode {

    private DcMotor motor1; // left
    private DcMotor motor2; // right

    // DEADZONE. tweak as you like, and also depending on controller
    private static final double DEADZONE = 0.05;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");

        // Flip one if wiring makes them oppose each other.
        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor2.setDirection(DcMotorSimple.Direction.FORWARD);

        // optional, testing
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("TCD ready. Left stick=Motor1, Right stick=Motor2");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // up = neg, down = pos -> invert to make up = forward
            double left = -gamepad1.left_stick_y;
            double right = -gamepad1.right_stick_y;

            // deadzone abs value maths, double check, might be wrong
            left = (Math.abs(left) < DEADZONE) ? 0.0 : left;
            right = (Math.abs(right) < DEADZONE) ? 0.0 : right;

            // (opt) fine control: square while preserving sign
            // left = Math.copySign(left * left, left);
            // right = Math.copySign(right * right, right);

            // Clip and apply
            left = Range.clip(left, -1.0, 1.0);
            right = Range.clip(right, -1.0, 1.0);

            motor1.setPower(left);
            motor2.setPower(right);

            // Debugging telemetry
            telemetry.addData("L stick / M1", "%.2f", left);
            telemetry.addData("R stick / M2", "%.2f", right);
            telemetry.update();
        }
    }
}
