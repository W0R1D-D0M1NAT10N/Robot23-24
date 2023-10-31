package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name="Driving22", group="12417")

public class DriverOp1 extends LinearOpMode {
    
    


    
    //DigitalChannel breakBeam;
    float MaxSpeed = 2.0f;
    @Override
    
    public void runOpMode() throws InterruptedException
    {
    DcMotor LMotor;
    DcMotor RMotor;  
    Servo SweepingDemon;
    DcMotor ArmMotor;
        waitForStart();
        while (opModeIsActive()) {
            LMotor = hardwareMap.dcMotor.get("motorLeft");
            RMotor = hardwareMap.dcMotor.get("motorRight");
            SweepingDemon = hardwareMap.servo.get("C_Servo");



            

            
            //breakBeam = hardwareMap.digitalChannel.get("Beam");

            DcMotor[] motors = {LMotor, RMotor};
            for (int i =0; i<2; i++)
            {
                motors[i].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                motors[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }
            LMotor.setDirection(DcMotor.Direction.REVERSE);
            RMotor.setDirection(DcMotor.Direction.FORWARD);

            Servo [] servos 

        float LPwr=0, RPwr=0; 
        
        
        LPwr= gamepad1.left_stick_y*MaxSpeed+gamepad1.left_stick_x*MaxSpeed;
        RPwr = gamepad1.left_stick_y*MaxSpeed- gamepad1.left_stick_x*MaxSpeed;

        if(gamepad1.left_stick_y>0)
        {
            LPwr=MaxSpeed/2;
            RPwr=MaxSpeed/2;

        }
        if(gamepad1.left_stick_y<0)
        {
            LPwr=-MaxSpeed/2;
            RPwr=-MaxSpeed/2;

        }
        if(gamepad1.left_stick_x>0)
        {
            LPwr=MaxSpeed/2;
            RPwr=-MaxSpeed/2;

        }
        if(gamepad1.left_stick_x<0)
        {
            LPwr=-MaxSpeed/2;
            RPwr=MaxSpeed/2;
        }


        while(gamepad1.x){
            DemonicSucker();
        }
        while(gampad1.right_bumper){
            MotorUp();
        }
        while(gamepad1.left_bumper){
            MotorDown();




        public void DemonicSucker(){
            SweepingDemon.setMode(Servo.RunMode.RUN_WITHOUT_ENCODER);
            SweepingDemon.setPower(Maxspeed);
        }
        public void MotorUp(){
            ArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            ArmMotor.setPower(.7f);
        }
        public void MotorDown(){
            ArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            ArmMotor.setPower(-.7f);
        }



            



            
        RMotor.setPower(RPwr);
        LMotor.setPower(LPwr);
        }

    }
}
