package com.example.fy_project;
import java.util.ArrayList;

import com.example.fy_project.Models.QuestionOptions;

public class QuestionRepository {

    public static ArrayList<QuestionOptions> getQuestionsForCategory(String category) {
        switch (category) {
            case "Depression":
                return getDepressionQuestions();
            case "Anxiety":
                return getAnxietyQuestions();
            case "Bipolar Disorder":
                return getBipolarDisordersQuestions();
            case "OCD":
                return getOCDQuestions();
            default:
                // Handle unknown category
                return new ArrayList<>();
        }
    }

    private static ArrayList<QuestionOptions> getDepressionQuestions() {
        ArrayList<QuestionOptions> depressionQuestions = new ArrayList<>();


        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I do not feel sad.", "I feel sad ", "I am sad all the time and I can't snap out of it. ", "I am so sad and unhappy that I can't stand it.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I am not particularly discouraged about the future.", "I feel discouraged about the future.", "I feel I have nothing to look forward to.", "I feel the future is hopeless and that things cannot improve.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I do not feel like a failure.", "I feel I have failed more than the average person.", "As I look back on my life, all I can see is a lot of failures.", "I feel I am a complete failure as a person. ", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I get as much satisfaction out of things as I used to.", "I don't enjoy things the way I used to.", "I don't get real satisfaction out of anything anymore.", "I am dissatisfied or bored with everything.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't feel particularly guilty.", "I feel guilty a good part of the time.", "I feel quite guilty most of the time.", "I feel guilty all of the time. ", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't feel I am being punished.", "I feel I may be punished.", "I expect to be punished.", "I feel I am being punished.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't feel disappointed in myself.", "I am disappointed in myself.", "I am disgusted with myself.", "I hate myself.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't feel I am any worse than anybody else.", "I am critical of myself for my weaknesses or mistakes.", "I blame myself all the time for my faults.", "I blame myself for everything bad that happens.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't have any thoughts of killing myself.", "I have thoughts of killing myself, but I would not carry them out.", "I would like to kill myself.", "I would kill myself if I had the chance.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't cry any more than usual.", "I cry more now than I used to.", "I cry all the time now.", "I used to be able to cry, but now I can't cry even though I want to.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I am no more irritated by things than I ever was.", "I am slightly more irritated now than usual.", "I am quite annoyed or irritated a good deal of the time.", "I feel irritated all the time.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I have not lost interest in other people.", "I am less interested in other people than I used to be.", "I have lost most of my interest in other people.", "I have lost all of my interest in other people.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I make decisions about as well as I ever could.", "I put off making decisions more than I used to.", "I have greater difficulty in making decisions more than I used to.", "I can't make decisions at all anymore.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't feel that I look any worse than I used to.", "I am worried that I am looking old or unattractive.", "I feel there are permanent changes in my appearance that make me look unattractive.", "I believe that I look ugly.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I can work about as well as before.", "It takes an extra effort to get started at doing something.", "I have to push myself very hard to do anything.", "I can't do any work at all.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I can sleep as well as usual.", "I don't sleep as well as I used to.", "I wake up 1-2 hours earlier than usual and find it hard to get back to sleep.", "I wake up several hours earlier than I used to and cannot get back to sleep.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I don't get more tired than usual.", "I get tired more easily than I used to.", "I get tired from doing almost anything.", "I am too tired to do anything.", 0, 1, 2, 3, "Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "My appetite is no worse than usual.", "My appetite is not as good as it used to be.", "My appetite is much worse now.", "I have no appetite at all anymore.", 0, 1, 2, 3,"Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I haven't lost much weight, if any, lately.", "I have lost more than five pounds.", "I have lost more than ten pounds.", "I have lost more than fifteen pounds.", 0, 1, 2, 3,"Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I am no more worried about my health than usual.", "I am worried about physical problems like aches, pains, upset stomach, or constipation.", "I am very worried about physical problems and it's hard to think of much else.", "I am so worried about my physical problems that I cannot think of anything else.", 0, 1, 2, 3,"Depression"));
        depressionQuestions.add(new QuestionOptions("Select the appropriate choice:", "I have not noticed any recent change in my interest in sex.", "I am less interested in sex than I used to be.", "I have almost no interest in sex.", "I have lost interest in sex completely.", 0, 1, 2, 3,"Depression"));

        return depressionQuestions;
    }

    private static ArrayList<QuestionOptions> getAnxietyQuestions() {
        ArrayList<QuestionOptions> anxietyQuestions = new ArrayList<>();

        anxietyQuestions.add(new QuestionOptions("Anxious mood \n" +
                "Worries, anticipation of the worst, fearful anticipation, irritability.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Tension \n" +
                "Feelings of tension, fatigability, startle response, moved to tears easily, trembling, feelings of restlessness, inability to relax.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Fears \n" +
                "Of dark, of strangers, of being left alone, of animals, of traffic, of crowds.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Insomnia \n" +
                "Difficulty in falling asleep, broken sleep, unsatisfying sleep and fatigue on waking, dreams, nightmares, night terrors.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Intellectual \n" +
                "Difficulty in concentration, poor memory.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Depressed mood \n" +
                "Loss of interest, lack of pleasure in hobbies, depression, early waking, diurnal swing.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Somatic (muscular) \n" +
                "Pains and aches, twitching, stiffness, myoclonic jerks, grinding of teeth, unsteady voice, increased muscular tone.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Somatic (sensory) \n" +
                "Tinnitus, blurring of vision, hot and cold flushes, feelings of weakness, pricking sensation.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Cardiovascular symptoms \n" +
                "Tachycardia, palpitations, pain in chest, throbbing of vessels, fainting feelings, missing beat.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Respiratory symptoms \n" +
                "Pressure or constriction in chest, choking feelings, sighing, dyspnea.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Gastrointestinal symptoms \n" +
                "Difficulty in swallowing, wind abdominal pain, burning sensations, abdominal fullness, nausea, vomiting, borborygmi, looseness of bowels, loss of weight, constipation.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Genitourinary symptoms \n" +
                "Frequency of micturition, urgency of micturition, amenorrhea, menorrhagia, development of frigidity, premature ejaculation, loss of libido, impotence.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Autonomic symptoms \n" +
                "Dry mouth, flushing, pallor, tendency to sweat, giddiness, tension headache, raising of hair.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));
        anxietyQuestions.add(new QuestionOptions("Behavior at interview \n" +
                "Fidgeting, restlessness or pacing, tremor of hands, furrowed brow, strained face, sighing or rapid respiration, facial pallor, swallowing, etc.", "Not at all", "Mild", "Moderate", "Severe", 0, 1, 2, 3, "Anxiety"));


        return anxietyQuestions;
    }

    private static ArrayList<QuestionOptions> getBipolarDisordersQuestions() {
        ArrayList<QuestionOptions> bipolarDisordersQuestions = new ArrayList<>();

        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you felt so good or so hyper that other people thought you were not your normal self or you were so hyper that you got into trouble?","No","Yes","","",0,3,0,0 ,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were so irritable that you shouted at people or started fights or arguments?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you felt much more self-confident than usual?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you got much less sleep than usual and found you didn’t really miss it?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were much more talkative or spoke faster than usual?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…thoughts raced through your head or you couldn’t slow your mind down?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were so easily distracted by things around you that you had trouble concentrating or staying on track?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you had much more energy than usual?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were much more active or did many more things than usual?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were much more social or outgoing than usual, for example, you telephoned friends in the middle of the night?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you were much more interested in sex than usual?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…you did things that were unusual for you or that other people might have thought were excessive, foolish, or risky?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\n…spending money got you or your family in trouble?","No","Yes","","",0,3,0,0,"Bipolar Disorder"));
        bipolarDisordersQuestions.add(new QuestionOptions("Has there ever been a period of time when you were not your usual self and…\nHow much of a problem did any of these cause you — like being able to work; having family, money, or legal troubles; getting into arguments or fights? ","No problem","Mild problem","Moderate problem","Serious problem",0,1,2,3,"Bipolar Disorder"));

        return bipolarDisordersQuestions;
    }

    private static ArrayList<QuestionOptions> getOCDQuestions() {
        ArrayList<QuestionOptions> ocdQuestions = new ArrayList<>();

        ocdQuestions.add(new QuestionOptions("I have saved up so many things that they get in the way.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I check things more often than necessary.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I get upset if objects are not arranged properly","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I feel compelled to count while I am doing things","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I find it difficult to touch an object when I know it has been touched by strangers or certain people","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I find it difficult to control my own thoughts","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I collect things I don’t need","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I repeatedly check doors, windows, drawers, etc.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I get upset if others change the way I have arranged things","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I feel I have to repeat certain numbers.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I sometimes have to wash or clean myself simply because I feel contaminated.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I am upset by unpleasant thoughts that come into my mind against my will.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I avoid throwing things away because I am afraid I might need them later.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I repeatedly check gas and water taps and light switches after turning them off.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I need things to be arranged in a particular way","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I feel that there are good and bad numbers","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I wash my hands more often and longer than necessary.","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));
        ocdQuestions.add(new QuestionOptions("I frequently get nasty thoughts and have difficulty in getting rid of them","Not at all","A little bit ","Moderately","Always",0,1,2,3, "OCD"));

        return ocdQuestions;
    }
}