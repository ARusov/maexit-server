package net.maexit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.maexit.entity.KeyValueDriver;
import net.maexit.entity.Question;
import net.maexit.service.KeyValueDriverService;
import net.maexit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 08.03.2018.
 */
@CrossOrigin
@RestController
public class TestController {

    @Autowired
    private KeyValueDriverService keyValueDriverService;
    @Autowired
    private QuestionService questionService;

    @CrossOrigin
    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "Hello World from Maexit!";
    }


    @RequestMapping("/test/kvd")
    @ResponseBody
    public List<KeyValueDriver> getKeyValueDrivers() {
        return keyValueDriverService.findAll();
    }


    @RequestMapping("/test/question")
    @ResponseBody
    public List<Question> getQuestions() {
        return questionService.findAll();
    }

    @RequestMapping("/test/insert")
    @ResponseBody
    public Object insert() throws IOException {

        String json="{\n" +
                "  \"qList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Haben Sie das Gefühl, dass Sie Ihre Buchhaltungsprozesse für das Bestehen einer externen Prüfung noch verbessern müssen?\",\n" +
                "      \"max\": \"Wir haben unsere Buchhaltung voll automatisiert und digitalisiert im Griff.\",\n" +
                "      \"min\": \"Ich schreibe meine Rechnungen mit Word und lege sie dann im Leitz Ordner ab.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Denken Sie, Sie könnten die  Produktivität Ihres Unternehmens noch besser ausschöpfen, wenn Sie das Wissen über Ihre Kunden und Ihre wichtigsten Kernprozesse präzise dokumentieren und offen verfügbar machen?\",\n" +
                "      \"max\": \"Unsere Wertschöpfungsprozesse und Kundeninfos sind voll dokumentiert und digitalisiert.\",\n" +
                "      \"min\": \"Prozesse sind nicht dokumentiert, sondern werden gelebt und das Wissen steckt in den Köpfen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Glauben Sie, daß Sie das Wissen Ihrer besten Mitarbeiter noch optimaler nutzen könnten, um innovative Produkte, effizientere Prozesse und mehr Profit zu erzielen?\",\n" +
                "      \"max\": \"Es gibt ein digitales Unternehmenswiki in dem das gesamte KnowHow, für alle zugänglich ist.\",\n" +
                "      \"min\": \"Das Wissen muss an neue Kollegen oder Chefs weitergegeben werden.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Denken Sie, daß Sie noch erfolgreicher sein könnten, wenn Sie die Top Experten Ihrer Branche für Ihr Unternehmen gewinnen könnten?\",\n" +
                "      \"max\": \"Es fällt uns sehr leicht, neue Fachkräfte zu rekrutieren und langfristig zu binden.\",\n" +
                "      \"min\": \"Es gelingt uns nicht, Fachkräfte zu rekrutieren und unsere Fluktuation zu senken.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Daten sind die neuen Wettbewerbsvorteile. Glauben Sie, daß Sie Ihre IT Infrastruktur und Big Data Nutzung noch verbessern könnten, für noch mehr Performance und Sicherheit?\",\n" +
                "      \"max\": \"Unsere eigene IT Abteilung / Partner betreut für uns die Infrastruktur und Sicherheit.\",\n" +
                "      \"min\": \"Eine professionelle Infrastruktur und Security Betreuung ist nicht vorhanden.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Glauben Sie, Sie könnten Ihre geschäftlichen Entscheidungen und Zielkontrollen noch erfolgreicher gestalten, um Ihre Wachstumsstrategie noch besser in Aktionen umzusetzen?\",\n" +
                "      \"max\": \"Wir überprüfen regelmäßig unsere Business-, Liquiditäts- und Bilanzplanung.\",\n" +
                "      \"min\": \"Wir erstellen bisher keine regelmäßige Planung über die Monatsebene hinaus.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Haben Sie das Gefühl, dass Sie mit der richtigen Nutzung von KPI Kennzahlen, noch schnellere und bessere finanzielle und strategische Aussagen und Entscheidungen treffen können?\",\n" +
                "      \"max\": \"Ich kenne und überwache alle wichtigen Kennzahlen und kann sofort einen Status Quo abrufen.\",\n" +
                "      \"min\": \"Ich arbeite nicht mit strategischen Kennzahlen für meine Unternehmenssteuerung.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"question\": \"Denken Sie, daß Sie mit den richtigen Beratern Ihre Unternehmensstrukturen- und -prozesse noch effizientergestalten könnten?\",\n" +
                "      \"max\": \"Wir haben in den wichtigsten strategischen Themen entsprechende Experten an unserer Seite.\",\n" +
                "      \"min\": \"Wir arbeiten nicht mit Beratern zusammen, da diese zu teuer sind sondern entscheiden intern.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"question\": \"Glauben Sie, dass Sie den Cashflow-Bedarf und die Liquiditäts-Beschaffung in Ihrem Unternehmen noch optimieren können?\",\n" +
                "      \"max\": \"Mein Unternehmen erwirtschaftet einen Überschuss, den ich an die Teilhaber ausschütten kann.\",\n" +
                "      \"min\": \"Wir brauchen mehr Cash als wir erwirtschaften, und versuchen ständig neues Kapital zu leihen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"question\": \"Haben Sie das Gefühl, dass Sie mit effektiveren Kunden-Zahlungsmodellen Ihren Cashflow noch stark verbessern können?\",\n" +
                "      \"max\": \"Bei uns werden 100%  fällig, wenn der Kunde den Kauf tätigt\",\n" +
                "      \"min\": \"Bei uns sind 100% zahlbar in 14-30 Tagen, nachdem der Kunde erhalten hat, was er gekauft hat\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"question\": \"Denken Sie, dass Sie mit effektiveren Lieferanten-Zahlungsmodellen Ihren Cashflow noch stark verbessern können?\",\n" +
                "      \"max\": \"Für uns sind 100% zahlbar in 14-30 Tagen, nachdem wir erhalten haben, was wir erworben haben\",\n" +
                "      \"min\": \"Für uns werden 100% fällig bei Kaufabschluss\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"question\": \"Glauben Sie, das Sie den Anteil von Overheadkosten im Verkaufspreis Ihrer Produkte und Services noch reduzieren könnten um Ihre Gewinnmarge zu steigern?\",\n" +
                "      \"max\": \"Unsere Overheadkosten betragen bereits nur 1%-5%\",\n" +
                "      \"min\": \"Unsere Overheadkosten betragen über 20%\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"question\": \"Denken Sie, dass es noch Optimierungspotenzial gibt, um Ihre Lager- und Lieferprozesse noch kosteneffektiver und leistungseffizienter zu gestalten?\",\n" +
                "      \"max\": \"Unsere Lieferkette ist optimiert und risikobewertet und wir liefern Just In Time.\",\n" +
                "      \"min\": \"Wir halten einen hohen Lagerbestand um Nachfragespitzen oder Engpässe abfedern zu können.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \" Ist der Anteil von wiederkehrenden Einnahmen an Ihrem Umsatz schon ausreichend, oder denken Sie, daß Sie mit weiteren, innovativen Vertragsmodellen noch mehr Umsatzsicherheit erzielen können?\",\n" +
                "      \"max\": \"Wir generieren unseren Umsatz zu 100% aus wiederkehrenden Einnahmen.\",\n" +
                "      \"min\": \"Unser Umsatz besteht zu 100% aus einmaligen Einnahmequellen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Die letzen Monate und Jahre waren ein voller Erfolg. Die Geschäftsabschlüsse waren so hoch wie noch nie. Wird das so bleiben oder glauben Sie, Sie könnten mit geeigneten Maßnahmen diese Erfolge wiederholen, wenn nicht sogar zu übertreffen?\",\n" +
                "      \"max\": \"Unsere Produkt- und Vertriebsstrategie und unser Salesteam sticht jeden Wettbewerber aus.\",\n" +
                "      \"min\": \"Wir kämpfen um jeden Auftrag.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Ist Ihr Umsatz bereits bestens gegen saisonale oder zyklische Schwankungen gewappnet oder könnten Sie mit cleveren Strategien Ihre Auslastung und Einnahmen effektiver gestalten?\",\n" +
                "      \"max\": \"Unsere Produktionsauslastung und Umsatz ist auf höchstem Niveau und völlig saisonunabhängig.\",\n" +
                "      \"min\": \"Wir müssen in wenigen Monaten den Umsatz reinholen, um das restliche Jahr davon zu zehren.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Haben Sie das Gefühl, die Risiken aus Ihren bestehenden Verträgen im Griff zu haben oder können Sie mit professioneller Anleitung versteckte Risiken besser identifizieren und Ihr Unternehmen dagegen absichern?\",\n" +
                "      \"max\": \"Meine Verträge sind zu 100% juristisch geprüft und risikobewertet.\",\n" +
                "      \"min\": \"Ich verwende branchenübliche Verträge. Eine Prüfung ist nicht erforderlich.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Wie sicher ist es, daß Sie nachhaltig die gleichen Umsätze auch in den nächsten Monaten / Jahren erzielen? Denken Sie, daß Sie noch mehr langfristige Umsatzquellen bzw. -sicherheit aufbauen sollten?\",\n" +
                "      \"max\": \"Wir haben zu 100% langfristige, unkündbare Verträge (>5 Jahre)\",\n" +
                "      \"min\": \"Unser Geschäftsmodel basiert zu 100% auf Einmalaufträgen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Unerwartete Veränderungen bei finanziellen Verpflichtungen und Verbindlichkeiten können ganze Unternehmen gefährden. Denken Sie, dass Sie die Strukturen und Belastungen Ihrer Verbindlichkeiten noch optimieren könnten?\",\n" +
                "      \"max\": \"Wir haben keine Verbindlichkeiten und sind frei von finanziellen Verpflichtungen\",\n" +
                "      \"min\": \"Die unerwartete Fälligstellung unserer Verpflichtungen führt zur direkten Insolvenz.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Glauben Sie, dass Ihre liquiden Mittel noch verbessern sollten, um 3-6 Monate den laufenden Betrieb vorfinanzieren zu können?\",\n" +
                "      \"max\": \"Unsere Barmittel reichen aus, um den Geschäftsbetrieb für 6 Monate vorzufinanzieren.\",\n" +
                "      \"min\": \"Wir benötigen die Einnahmen aus jedem Monat, um unseren Betrieb zu finanzieren.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"question\": \"Haben Sie das Gefühl, sich und Ihr Unternehmen noch besser gegen existenzgefährdende Risiken absichern zu können? \",\n" +
                "      \"max\": \"Wir haben die größten persönlichen und unternehmerischen Risiken mit Versicherungen abgedeckt.\",\n" +
                "      \"min\": \"Wir sind definitiv unterversichert und einem existenziellem Risiko schutzlos ausgesetzt.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Denken Sie, Sie könnten Ihre Produkt- und Dienstleistungspallette noch breiter und globaler aufstellen??    \",\n" +
                "      \"max\": \"Wir verfügen über eine breite Produktpalette und sind global sehr gut aufgestellt.\",\n" +
                "      \"min\": \"Wir bieten nur wenige Produkte an und unser, Absatz ist nur im deutschsprachigen Raum\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Glauben Sie, Sie könnten mit erprobten Strategien, Ihre Produkte und Dienstleistungen besser etablieren, Ihre Produktführerschaft auf- bzw. ausbauen und eine starke Preissetzungsmacht erzielen?\",\n" +
                "      \"max\": \"Wir haben einzigartige Produkte und eine sehr hohe Preisgestaltungsmacht, Kunden kaufen fast zu jedem Preis.\",\n" +
                "      \"min\": \"Wir haben austauschbare Produkte und sehr geringe Preisgestaltungsmacht, meist zu Lasten unserer Marge.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Glauben Sie, daß Sie mit passenden Maßnahmen weitere Großkunden gewinnen und Ihre Abhängigkeit von einzelnen Auftraggebern reduzieren könnten?\",\n" +
                "      \"max\": \"Meine größten Kunden machen maximal 1%-15% von unserem Gesamtumsatz aus.\",\n" +
                "      \"min\": \"Mein größter Kunde hat einen Umsatzanteil von mehr als 50%.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Haben Sie das Gefühl, daß Sie noch weitere Maßnahmen ergreifen müssen, um Ihr Unternehmen unabhängiger von kritischen Wissensmonopolen und persönlichen Entscheiderkontakten Ihrer Mitarbeiter zu machen?\",\n" +
                "      \"max\": \"Entscheidendes Wissen und Kontakte sind dokumentiert und gesichert.\",\n" +
                "      \"min\": \"Die Mitarbeiten sollen Ihr Wissen und Kontakte an Vertretungen und Nachfolger weitergeben.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Denken Sie, dass Sie Ihre Recruiting Aktivitäten in soziale Medien bzw. interne Anreizsysteme effektiver ausschöpfen können, um kritische bzw. einzigartige Fachkräfte zu binden bzw. einen Ausfall abzusichern?\",\n" +
                "      \"max\": \"Wir haben jede Schlüsselposition doppelt besetzt und bauen stetig interne Ressourcen auf\",\n" +
                "      \"min\": \"Eine Doppelbesetzung können wir uns nicht leisten und wir schreiben nur nach Bedarf neue Stellen aus.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Haben Sie das Gefühl, daß Sie mit passenden Maßnahmen weitere Alternativ-Lieferanten aufbauen und Ihre Abhängigkeit von einzelnen Zulieferern reduzieren können?\",\n" +
                "      \"max\": \"Wir haben unsere Kernbedarfe mit mind. 2 Lieferanten abgedeckt\",\n" +
                "      \"min\": \"Unsere Abhängigkeit von Kernlieferanten kann bei Ausfall zum Lieferstop führen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"question\": \"Denken Sie, dass Sie alternative Technologien aufbauen können, um unabhängig von technischen oder politischen Veränderungen bzw. Marktanforderungen zu sein?\",\n" +
                "      \"max\": \"Wir sind unabhängig von einer einzelnen Technologie und könnten leicht auf Alternativen wechseln.\",\n" +
                "      \"min\": \"Der Wegfall einer Kerntechnologie würde zum Produktionsstillstand führen, bis eine Alternative verfügbar ist.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Haben Sie gefühlt Ihr Kundenmaximum schon erreicht oder denken Sie, daß Sie noch Potenzial haben, auf alten und neuen Wegen weitere Kunden gewinnen zu können?\",\n" +
                "      \"max\": \"Wir können unsere Produktion und Dienstleistung einfach skalieren und jede Nachfrage schnell befriedigen.\",\n" +
                "      \"min\": \"Unser Kundenmaximum ist erreicht und wir haben keine Kapazitäten mehr für Neukunden.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Glauben Sie, daß Sie noch lukrativere, digitale Produkte für Ihre Kundengruppen entwickeln können, die sich am geänderten, digitalen Verhalten Ihrer Kunden orientieren?\",\n" +
                "      \"max\": \"Unsere Produkte und Dienstleistungen sind zu 100% dem digitalen Verhalten und Anspruch unsere Kunden angepasst.\",\n" +
                "      \"min\": \"Unsere Produkte und Dienstleistungen können nicht dem digitalen Kundenanspruch angepasst bzw. neuentwickelt werden.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Denken Sie, daß Sie bei Ihren Kunden noch weitere bzw. komplementäre Produkte aus Ihrem Portfolio platzieren können?\",\n" +
                "      \"max\": \"Es gibt eine Menge Produkte oder Services, die wir an unsere bestehenden Kunden verkaufen könnten.\",\n" +
                "      \"min\": \"Unsere Kunden sind gesättigt. Wir verkaufen Ihnen schon Alles.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Haben Sie das Gefühl dass Sie mit erprobten Strategien neue Märkte aufbauen und lukrative Marktchancen schneller realisieren können?\",\n" +
                "      \"max\": \"Wir sind in einer Wachstumsbranche und wir sind in allen verfügbaren Märkten bereits vertreten.\",\n" +
                "      \"min\": \"Unsere Branche ist rückläufig und wir sind mit unseren Produkten und Dienstleistungen sehr regional gebunden.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Denken Sie, dass Sie Ihren Marktanteil und den verfügbaren Markt noch weiter aus- und aufbauen können?\",\n" +
                "      \"max\": \"Ich bin Monopolist in einem ständig erweiterbarem Marktsegment.\",\n" +
                "      \"min\": \"Unser Marktanteil ist nicht messbar in einem nicht definierbarem Markt.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Anstatt eigene, langwierige Entwicklungen voranzutreiben, glauben Sie, dass Sie Ihr Akquise-Kapital noch aufstocken könnten, um strategisch oder finanziell passende Unternehmen aufzukaufen?\",\n" +
                "      \"max\": \"Unsere M&A Kasse ist bestens gefüllt und wir sondieren potenzielle Übernahmekandidaten.\",\n" +
                "      \"min\": \"Wir haben keine messbare Brand- und Marketingstrategie.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Denken Sie, Sie könnten Ihre Brand- und Marketingstrategie noch schärfen, um kontinuierlich neue Interessenten zu generieren?\",\n" +
                "      \"max\": \"Wir haben eine gute Strategie, die täglich neue Interessenten in unsere Verkaufspipeline spült.\",\n" +
                "      \"min\": \"Geld für Zukäufe können wir nicht investieren, wenn, dann entwickeln wir selber.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"question\": \"Denken Sie, daß Sie sich so positionieren können, dass Sie ein Nischenprodukt / Service anbieten, dass auf dem Markt so einzigartig ist, so dass Ihre Kunden hart arbeiten müssen, um einen anderen Anbieter zu finden, der anbietet was Sie verkaufen?\",\n" +
                "      \"max\": \"Wir stechen jeden Wettbewerber durch unschlagbares Preis/Leistungsverhältnis und Qualität aus.\",\n" +
                "      \"min\": \"Wir müssen jeden Wettbewerber zu Lasten der Rentabilität unterbieten, um an Aufträge zu kommen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Denken Sie, dass Sie die Innovationskultur und das Markenmanagement in Ihrem Unternehmen noch ausbauen können, um langfristig an der Spitze zu bleiben?\",\n" +
                "      \"max\": \"Unsere R&D Abteilung arbeitet ständig an Innovationen, die auch von Mitarbeitern initiiert werden.\",\n" +
                "      \"min\": \"Innovationen sind nicht nötig. Wir waren immer an der Spitze und werden es auch bleiben.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Glauben Sie, daß Sie noch mehr Profit aus der digitalen Transformation Ihres Unternehmens holen könnten?\",\n" +
                "      \"max\": \"Unser Kerngeschäft hat eine hohe digitale Reife und digitale Geschäftsmodelle sind etabliert.\",\n" +
                "      \"min\": \"Wir haben eine eigene Webseite / Onlineshop.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Glauben Sie, dass Sie die Kosteneffizienz- und Produktivitätssteigerungs-effekte der Digitalisierung schon voll ausgeschöpft haben oder können Sie sich vorstellen, dass es noch unentdeckte Hebel gibt, die Ihre Prozesse und Erträge verbessern können?\",\n" +
                "      \"max\": \"Wir haben unsere gesamte Wertschöpfungskette voll digitalisiert und automatisiert.\",\n" +
                "      \"min\": \"Wir nutzen emails und der Rest ist manuelle Arbeit, die nicht digitalisiert werden kann.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Denken Sie, dass Sie computergestützte Verfahren noch stärker nutzen können, um Ihre Supply Chain und Produktivität auf dem höchsten, ausfallminimierten Leistungsniveau zu halten?\",\n" +
                "      \"max\": \"Unsere Kernsysteme sind maximal ausfallgesichert und auf höchstem Level konfigurierbar.\",\n" +
                "      \"min\": \"Wir verlassen uns nicht auf Computer und kümmern uns um Ausfälle wenn notwendig.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Mit jeder industriellen Revolution entstehen neue Branchen. Denken Sie, dass Sie durch den Einsatz neuer Technologien völlig neue Geschäftsfelder aufbauen können?\",\n" +
                "      \"max\": \"Wir treiben den Einsatz neuer Technologien zum Aufbau neuer Geschäftsfelder intensiv voran.\",\n" +
                "      \"min\": \"Wir kümmern uns um die Aufrechterhaltung unseres aktuellen Geschäftsbetriebes.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Glauben Sie, dass Sie in Ihrem Unternehmen durch weitere Investitionen bzw. Modernisierungen den wachsenden Anforderungen des Marktes mehr gerecht werden können?\",\n" +
                "      \"max\": \"Unsere Maschinen und Infrastruktur ist auf dem neusten Stand der Technik und weitere Investitionen sind nicht notwendig.\",\n" +
                "      \"min\": \"Investitionen und Modernisierungen halten wir zurück, um unsere Bilanz aufzubessern.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"question\": \"Daten sind die neuen Firmenwerte. Haben Sie das Gefühl, dass Sie hilfreiche Daten in Ihrem Unternehmen noch besser erfassen und nutzen für mehr Umsatz und Effektivität nutzen zu können?\",\n" +
                "      \"max\": \"Wir bekommen von allen Prozessen und Schnittstellen Daten in Echtzeit.\",\n" +
                "      \"min\": \"Wir wissen nicht, welche Daten wir sammeln und nutzen sollen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"question\": \"Haben Sie das Gefühl, Sie müssen Ihr Unternehmen noch besser vorbereiten, wenn Sie das Tagesgeschäft von heute auf morgen verlassen würden?\",\n" +
                "      \"max\": \"Alle (Entscheidungs-)Prozesse in meinem Unternehmen laufen auch ohne mich.\",\n" +
                "      \"min\": \"Ohne mich geht gar nichts im Tagesgeschäft. Das Unternehmen würde zum Stillstand kommen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"question\": \"Wenn Sie Ihr Unternehmen verlassen werden, denken Sie, dass Sie die Auswirkungen auf Unternehmenskultur, Kundenbeziehungen und gesellschaftlichen Wahrnehmungen bereits ausreichend bedacht haben oder müssen Sie diesbzgl. noch wichtige Themen besser vorbereiten?\",\n" +
                "      \"max\": \"Ich habe die Kunden- Und gesellschaftlich relevanten Bereiche darauf vorbereitet, eines Tages das Unternehmen zu verlassen.\",\n" +
                "      \"min\": \"Keine Ahnung, wenn ich weg bin, bin ich weg.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"question\": \"Können Sie Ihr Unternehmen kurzfristig verlassen oder denken Sie, dass Sie Ihr Ausscheiden noch besser mit wichtigen, externen Ansprechpartnern  vorbereiten können? \",\n" +
                "      \"max\": \"Ich kann alle externen Verpflichtung sofort auflösen und eingebrachte Sicherheiten ablösen.\",\n" +
                "      \"min\": \"Es wurden Verpflichtungen eingegangen und Sicherheiten gebunden, die aus- und abzulösen sind.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"question\": \"Glauben Sie, dass Sie Entscheidungsstrukturen in Ihrem Unternehmen noch verbessern können, um schneller und unbürokratischer wichtigen Entscheidungen zu treffen?\",\n" +
                "      \"max\": \"Ich treffe alle Entscheidungen alleine und lege niemandem Rechenschaft darüber ab.\",\n" +
                "      \"min\": \"Ich muss Entscheidungen durch verschiedene externe, interne und familiäre Gremien genehmigen lassen.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"question\": \"Für den Fall, dass Sie das Unternehmen verlassen, haben Sie das Gefühl, dass Sie die Handlungsfähigkeit Ihres Vertreters/ Ihrer Managementebene noch verbessern müssen, damit diese das Unternehmen und Entscheidungen in Ihrem Sinne treffen und erfolgreich umsetzen können?\",\n" +
                "      \"max\": \"Wir haben ein Management-Team mit wachstumsorientierten Anreizverträgen ausgestattet.\",\n" +
                "      \"min\": \"Es gibt kein Managementteam. Ich bin immer erreichbar und in alle Entscheidungsprozesse und Aktivitäten involviert.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"question\": \"Glauben Sie, dass Sie den Prozentsatz Ihrer Kunden, die SEHR ZUFRIEDEN mit den Dienstleistungen / Produkten sind, die Ihr Unternehmen bietet, noch steigern können?\",\n" +
                "      \"max\": \"Es sind bereits mehr als 90% unserer Kunden \\\"sehr zufrieden\\\".\",\n" +
                "      \"min\": \"Ich bin mir nicht sicher - wir messen nicht die Kundenzufriedenheit.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"question\": \"Denken Sie, dass Sie Ihren Einfluss (gemessen an der Anzahl der Menschen, die sich über email Listen oder Social Media Profile für Informationen über Ihr Unternehmen interessieren)noch steigern können?\",\n" +
                "      \"max\": \"Wir erreichen bereits mehr als 100.000 interessierte Personen.\",\n" +
                "      \"min\": \"Wir haben keine weiteren Interessentenlisten außer unserer Kundendatei.\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"question\": \"Denken Sie, Sie können die Anzahl der Lizenznehmer und Kunden erhöhen, deren Geschäftserfolg von den Produkten und Dienstleistungen Ihres Unternehmens abhängig sind?\",\n" +
                "      \"max\": \"Die meisten Geschäftspartner müssen kaufen, was wir zur Verfügung stellen (mehr als 90% Erfolgsabhängigkeit)\",\n" +
                "      \"min\": \"Ein sehr kleiner Anteil der Geschäftspartner müssen kaufen, was wir zur Verfügung stellen (weniger als 10% Erfolgsabhängigkeit)\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"question\": \"Haben Sie das Gefühl, dass Sie die Wahrnehmung Ihres Unternehmens am Markt bei Kunden, Geschäftspartnern und Mitarbeitern noch verbessern könnten?\",\n" +
                "      \"max\": \"Hohe Qualität, entsprechende Bezahlung, und spannende Produkte für die Kunden bereit sind, Geld zu investieren\",\n" +
                "      \"min\": \"Unfaire Bezahlung und Preisgestaltung zur Profitmaximierung und zu Lasten von Qualität und Service\",\n" +
                "      \"value\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"question\": \"Denken Sie, dass Sie weitere Attraktivitätsfaktoren, wie \\\"geistiges Eigentum\\\" oder vorteilhafte Verträge / Handelsabkommen, Auszeichnungen, Zertifizierungen, etw. aufbauen könnten?\",\n" +
                "      \"max\": \"Wir besitzen bereits unzählige Awards, Zertifizierungen, Patente, exklusive Handelsabkommen.\",\n" +
                "      \"min\": \"Wir besitzen die branchenüblichen Standardzertifizierungen. Um mehr haben wir uns bisher keine Gedanken gemacht.\",\n" +
                "      \"value\": 0\n" +
                "    }\n" +
                "  ]\n" +
                "}";



        return json;
    }

}
