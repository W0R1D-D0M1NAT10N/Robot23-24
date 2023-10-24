package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



public class ArmSys
{
    private DcMotor jellyArm = null;
    private Servo jellyFish = null;
    private DcMotor clawArm = null;
    private Servo clawOne = null;
    private Servo clawTwo = null; 
    
    private DcMotor FLMotor; //hmm? - tv
    private DcMotor FRMotor;
    private DcMotor BLMotor;
    private DcMotor BRMotor;
    
    private boolean clawHold;
    private float clawPosition;
    private int clawwArmFront = 0; //to be tested and modified
    private int clawArmBack = 0; // ""
    private int jelly0 = 0; // ""
    private int jelly0_5 = 0; //""
    private int jelly1 = 0; //""
    private int jelly2 = 0; // ""
    private int jelly3 = 0; //...and here too
    


    public ArmSys(HardwareMap hardwareMap)
    {
        jellyArm = hardwareMap.dcMotor.get("H_Motor");
        jellyFish = hardwareMap.servo.get("H_Servo");
        clawArm =hardwareMap.dcMotor.get("C_Motor");
        claw1 = hardwareMap.servo.get("C_Servo1");
        claw2 = hardwareMap.servo.get("C_Servo2");
        
        FRMotor = hardwareMap.dcMotor.get("FR_Motor"); //hmm? - tv
        FLMotor = hardwareMap.dcMotor.get("FL_Motor");
        BRMotor = hardwareMap.dcMotor.get("BR_Motor");
        BLMotor = hardwareMap.dcMotor.get("BL_Motor");

        jellyArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //hmm? isn't auto-op entirely encoder-based? - tv
        clawArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    

    public void resetArms()
    {
        jellyArm.setTargetPosition(jelly0_5);
        jellyArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        closeClaw();
        
        sleep(1000);
        clawArm.setTargetPosition(clawArmBack);
        clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        openClaw();
    }
    public void grab()
    {
        closeClaw();

        jellyArm.setTargetPosition(jelly0_5);
        jellyArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        clawArm.setTargetPosition(clawwArmFront);
        clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        
        openClaw();
        sleep(200);
        resetArms();

    }
    public void junctionPlace()
    {
        clawArm.setTargetPosition(clawArmBack);
        clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        openClaw();
    }
    public void junctionPlace (int a)
    {
        jellyArm.setTargetPosition(jelly0);
        jellyArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        expandJelly();
        sleep(200);
        
        if(a==1)
        {
            jellyArm.setTargetPosition(jelly1);
        }
        else if (a==2)
        {
            jellyArm.setTargetPosition(jelly2);
        }
        else if(a==3)
        {
            jellyArm.setTargetPosition(jelly3);
        }
        
        jellyArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(1000);
        collapseJelly();
        // jellyArm.setTargetPosition(jelly0);
        // jellyArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    public void openClaw()
    {
        clawOne.setPosition(2.0f);
        clawTwo.setPosition(2.0f);
    }
    public void closeClaw()
    {
        clawOne.setPosition(0.0f);
        clawTwo.setPosition(0.0f);
    }

   
    public void expandJelly()
    {
        jellyFish.setPosition(2.0f);
    }
    public void collapseJelly()
    {
        jellyFish.setPosition(0.0f);
    }
    


}

