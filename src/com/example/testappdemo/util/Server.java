package com.example.testappdemo.util;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class Server
{
	private static final String[]	titles			= { "Pellentesque porttitor venenatis odio eget", "Ullum utamur vis",
			"Sit adhuc integre constituto ne, graeco", "Vidit dissentiunt nec", "Pro semper accumsan ex at", "An vis clita vitae comprehensam",
			"His blandit vituperata temporibus ut, elitr corpora", "Ad qui saepe vitae. Vel atqui aliquam percipit", "Ex stet neglegentur vim",
			"Est fabellas volutpat adipiscing cu. Cu quas partiendo", };
	private static final String[]	descriptions	= {
			"Lorem ipsum dolor sit amet, has te hinc dolor, consequat similique mel id. Semper platonem ius ut. Omnis habemus molestiae cu pro. Error quaestio per et. Mei no dicat volumus laboramus, malorum appareat aliquando eum ei.",
			"Ne vim stet hinc sententiae, vel dico dicant salutatus ei. Ex elit quaestio aliquando nec, eam ne quando latine tacimates, per eripuit indoctum ne. Ea iudico nullam evertitur per, vix docendi deserunt dissentias in, at expetenda appellantur cum. Possim eleifend at sea, sumo modus solet ad nam.",
			"Te mei ipsum impetus posidonium. Per ea nonumy vituperatoribus, in sea essent voluptaria. Altera indoctum usu eu, ut quo assum veniam timeam, nam feugiat lobortis ad. Mea ea putent vocent euismod. Ex suscipit platonem mandamus duo.Platonem argumentum instructior eam ne, eos at debet vivendum, sonet prompta mel id. Verear option docendi vis an. Eum ea ponderum constituto, eu fugit iisque mea. Tale consul utamur ei eam.Possim iisque an cum, nisl assum iriure et duo. Eruditi constituto intellegebat cu usu, pro cetero moderatius et, te tritani accusam delectus mel. Prompta rationibus nec eu, no vis labore laoreet dissentiunt vix.",
			"Verterem incorrupte liberavisse ut duo. Vix corpora laboramus ei, no verterem expetenda contentiones sit. An blandit electram referrentur eum, has liber voluptatum ut. Ea urbanitas vituperata instructior duo. Id diceret accusata nec, sed putent quaestio vituperatoribus in.Duo in consul forensibus, id sit alterum disputationi, eros impetus blandit sit at. An vix augue tollit delicatissimi. Omnes dicant persius has ut, eum unum luptatum ne, has atqui ullum in. Ornatus forensibus reprehendunt et eos, oblique apeirian nec ei, usu clita putant scaevola id. Solum dissentiunt usu no, partiendo hendrerit duo ad. An impetus eleifend consetetur per, tale iuvaret sapientem ex est",
			"Aliquip euismod corrumpit qui eu, laudem latine in vel. Per eu alia assentior, ea sonet quaerendum qui. Ius tempor postea audiam ea, alia stet posidonium ut cum, quo tale nulla mnesarchum no. At clita partiendo has, omnesque facilisi eam ut. Duo melius volumus adipisci id, ferri melius est ex. An per ancillae scriptorem, indoctum sententiae nam ne, vivendo sapientem complectitur no nam. Est ut malis latine suavitate, his cu nibh recteque adolescens.",
			"Sed at augue necessitatibus. Dicta simul platonem ius ea, suas legimus signiferumque id sea, no vim movet doming dolores. Et alterum detracto sit, reque harum cu has. Eum altera iuvaret ut, te putent eruditi impedit his, at integre feugait nam.",
			"At sint scriptorem mel, labitur impedit et nec, ut fugit pericula referrentur his. Has an sint postea eleifend, duo graeci labitur no, paulo oratio at usu. Ex tritani albucius pro, ex regione invidunt signiferumque eos, at mei sumo efficiantur definitiones. Dicant ignota est an, ea ius harum mollis accommodare, sea idque mediocrem no. Vim movet saperet iudicabit et. Te nam vidit epicuri salutatus, sed atqui legere intellegebat ei.",
			"Lorem ipsum dolor sit amet, alii bonorum nominavi ne nam, nullam bonorum patrioque eu ius, sed ea etiam constituto. Eam ad elit movet praesent, modus mentitum mediocrem vel in. Sit suavitate ullamcorper ex, laudem cetero apeirian at usu, soleat efficiendi eum an. Quot invidunt mandamus at vim, qui adhuc voluptua ex, iudico aeterno reprehendunt ex vim. An eam causae referrentur, eu graecis patrioque his, his purto velit neglegentur id.",
			"Ius no impetus tincidunt, in vis movet quando. Praesent laboramus intellegat sed et, quod nemore molestiae eum ex. No mei ignota fuisset tractatos, quo quem suavitate necessitatibus ut. Mei sapientem vituperatoribus id. Nec ocurreret patrioque disputando te, gloriatur assueverit dissentias ei est. Te vix tantas aliquam, te vitae adversarium quo, at eros zril neglegentur est.",
			"In autem pertinax vix. Tamquam meliore reprimique mei ex, an tibique suscipiantur est, feugait propriae has te. Sit suas enim at, at aliquando torquatos nec. Ut possim utroque inermis nam. Usu epicurei tacimates inimicus at." };
	private static final int[]		percents		= { 59, 35, 0, 88, 100, 66, 50, 25, 71, 98 };
	private static final String[]	colors			= { "09C", "690", "F80", "C00", "93C", "33B5E3", "9C0", "FB3", "F44", "A6C" };

	/**
	 * @return JSON for items.
	 * @throws Exception
	 */
	public static String getItems() throws Exception
	{
		final Random r = new Random();
		final JSONArray jArray = new JSONArray();
		JSONObject jObject;
		for (int i = 0; i < 10; i++)
		{
			jObject = new JSONObject();
			jObject.put("server_id", i + 1);
			jObject.put("image_url", "http://dummyimage.com/" + (r.nextInt(1970) + 30) + "/" + colors[i]);
			jObject.put("title", titles[i]);
			jObject.put("description", descriptions[i]);
			jObject.put("percent", percents[i]);
			jArray.put(jObject);
		}

		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			// Ignore
		}

		return jArray.toString();
	}
}