import static java.lang.System.*;
import javax.sound.midi.*;

public class Spade {
       public static void main(String[] args){
           Spade s=new Spade();
           args=new String[]{"1","60"};
           if(args.length<2){
               out.println("Don't forget the instrument and note args");
           }else{
               int instrument =Integer.parseInt(args[0]);
               int node =Integer.parseInt(args[1]);
               s.plays(instrument,node);
           }

       }

    public void play(){
        try{
            Sequencer player =MidiSystem.getSequencer();
            player.open();

            Sequence seq=new Sequence(Sequence.PPQ,4);

            Track track= seq.createTrack();
            ShortMessage a= new ShortMessage();
            a.setMessage(144,1,54,100);//(类型，频道，音符，音道[力度])；144代表打开，128代表关闭
            MidiEvent noteOn=new MidiEvent(a,1);//音延
            track.add(noteOn);

            ShortMessage b=new ShortMessage(128,1,54,100);
            MidiEvent noteOff=new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void plays(int instrument,int note){
           try{
               Sequencer player=MidiSystem.getSequencer();
               player.open();
               Sequence seq=new Sequence(Sequence.PPQ,4);
               Track track= seq.createTrack();

               MidiEvent event=null;

               ShortMessage first=new ShortMessage();
               first.setMessage(192,1,instrument,0);
               MidiEvent changeInstrument=new MidiEvent(first,1);
               track.add(changeInstrument);

               ShortMessage a=new ShortMessage();
               a.setMessage(144,1,note,100);
               MidiEvent noteOn=new MidiEvent(a,1);
               track.add(noteOn);

               ShortMessage b=new ShortMessage();
               b.setMessage(128,1,note,100);
               MidiEvent noteOff=new MidiEvent(a,16);
               track.add(noteOff);

               player.setSequence(seq);
               player.start();
           }catch (Exception ex){
               ex.printStackTrace();
           }
    }
    }
