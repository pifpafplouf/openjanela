/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.ImageIcon;
import javax.swing.JApplet;


public final class ResourceJarReader
	{

	public static boolean debugOn = false;

	private static Hashtable<String, Integer> htSizes =
			new Hashtable<String, Integer>();

	private static Hashtable<String, byte[]> htJarContents =
			new Hashtable<String, byte[]>();

	private static String jarFileName = null;

	public static HashMap<?, ?> imageIconMap =
			new HashMap<Object, Object>();

	private ResourceJarReader()
		{

		}

	public static void setJarFileName(final String fileName)
		{

		jarFileName = fileName;
		init();
		}

	public static byte[] getResource(final String name)
		{

		return htJarContents.get(name);
		}

	public static ImageIcon getImageIcon(final String imageName)
		{

		final ImageIcon ic = new ImageIcon(getResource(imageName))
			{

				@Override
				public String getDescription()
					{

					return imageName;
					}

				@Override
				public String toString()
					{

					return imageName;
					}

			};
		return ic;
		}

	private static void init()
		{

		try
			{
			final ZipFile zf = new ZipFile(jarFileName);
			ZipEntry ze;
			for (final Enumeration e = zf.entries(); e
					.hasMoreElements(); htSizes.put(
					ze.getName(),
					new Integer((int) ze.getSize())))
				{
				ze = (ZipEntry) e.nextElement();
				if (debugOn)
					{
					System.out.println(dumpZipEntry(ze));
					}
				}

			zf.close();
			final FileInputStream fis =
					new FileInputStream(jarFileName);
			final BufferedInputStream bis =
					new BufferedInputStream(fis);
			final ZipInputStream zis = new ZipInputStream(bis);
			ze = null;
			do
				{
				if ((ze = zis.getNextEntry()) == null)
					{
					break;
					}
				if (!ze.isDirectory())
					{
					if (debugOn)
						{
						System.out.println(String.valueOf(String
								.valueOf(new StringBuffer(
										"ze.getName()=")
										.append(ze.getName())
										.append(",")
										.append("getSize()=")
										.append(ze.getSize()))));
						}
					int size = (int) ze.getSize();
					if (size == -1)
						{
						size = htSizes.get(ze.getName()).intValue();
						}
					final byte b[] = new byte[size];
					int rb = 0;
					int chunk = 0;
					do
						{
						if (size - rb <= 0)
							{
							break;
							}
						chunk = zis.read(b, rb, size - rb);
						if (chunk == -1)
							{
							break;
							}
						rb += chunk;
						}
					while (true);
					htJarContents.put(ze.getName(), b);
					if (debugOn)
						{
						System.out
								.println(String
										.valueOf(String
												.valueOf(new StringBuffer(
														String
																.valueOf(String
																		.valueOf(ze
																				.getName())))
														.append(
																"  rb=")
														.append(rb)
														.append(
																",size=")
														.append(size)
														.append(
																",csize=")
														.append(
																ze
																		.getCompressedSize()))));
						}
					}
				}
			while (true);
			}
		catch (final NullPointerException e)
			{
			System.out.println("done.");
			}
		catch (final FileNotFoundException e)
			{
			((Throwable) e).printStackTrace();
			}
		catch (final IOException e)
			{
			((Throwable) e).printStackTrace();
			}
		}

	private static String dumpZipEntry(final ZipEntry ze)
		{

		final StringBuffer sb = new StringBuffer();
		if (ze.isDirectory())
			{
			sb.append("d ");
			}
		else
			{
			sb.append("f ");
			}
		if (ze.getMethod() == 0)
			{
			sb.append("stored   ");
			}
		else
			{
			sb.append("defaulted ");
			}
		sb.append(ze.getName());
		sb.append("\t");
		sb.append("".concat(String.valueOf(String.valueOf(ze
				.getSize()))));
		if (ze.getMethod() == 8)
			{
			sb.append("/".concat(String.valueOf(String.valueOf(ze
					.getCompressedSize()))));
			}
		return sb.toString();
		}

	public static void main(final String args[]) throws IOException
		{

		setJarFileName("erpiccoloresources.jar");
		final byte buff[] = getResource("1GridH.jpg");
		if (buff == null)
			{
			System.out.println(String.valueOf(String
					.valueOf(new StringBuffer("Could not find ")
							.append(args[0])
							.append("."))));
			}
		}

	public static ImageIcon getIcon(final URL imageNameURL)
		{

		final ImageIcon ic = new ImageIcon(imageNameURL);
		return ic;
		}

	public static HashMap<String, ImageIcon> loadImageIconMap()
		{

		final HashMap<String, ImageIcon> imageIcon_Map =
				new HashMap<String, ImageIcon>();

		imageIcon_Map.put("pos1In", getImageIcon("pos1In.png"));

		imageIcon_Map.put("pos2Mid", getImageIcon("pos2Mid.png"));

		imageIcon_Map.put("pos3Out", getImageIcon("pos3Out.png"));

		imageIcon_Map.put("error", getImageIcon("error.png"));

		imageIcon_Map.put("bayC1", getImageIcon("bayC1.png"));

		imageIcon_Map.put("bayC2", getImageIcon("bayC2.png"));

		imageIcon_Map.put("undo", getImageIcon("undo.png"));
		imageIcon_Map.put("tip", getImageIcon("tip.png"));
		imageIcon_Map.put("add", getImageIcon("add.png"));

		imageIcon_Map.put("add", getImageIcon("add.png"));

		imageIcon_Map.put("add", getImageIcon("add.png"));

		imageIcon_Map.put("grids16", getImageIcon("grids16.png"));
		imageIcon_Map.put("glass16", getImageIcon("glass16.png"));
		imageIcon_Map.put(
				"designFunction",
				getImageIcon("design.png"));
		imageIcon_Map.put("options", getImageIcon("options.png"));

		imageIcon_Map.put("add", getImageIcon("add.png"));

		imageIcon_Map.put("change", getImageIcon("change.png"));

		imageIcon_Map.put("set", getImageIcon("set.png"));
		
		imageIcon_Map.put("goset", getImageIcon("set.png"));

		imageIcon_Map.put("save", getImageIcon("save.png"));

		imageIcon_Map.put("cancel", getImageIcon("cancelstop.png"));

		imageIcon_Map.put(
				"couplermullion",
				getImageIcon("couplermullion.png"));

		imageIcon_Map.put("shapes", getImageIcon("shapes.png"));
		imageIcon_Map.put("subFrame", getImageIcon("subFrame.png"));

		imageIcon_Map.put("entry", getImageIcon("entry.png"));

		imageIcon_Map.put("doors", getImageIcon("doors.png"));

		imageIcon_Map.put("windows", getImageIcon("windows.png"));
		
		imageIcon_Map.put("standard", getImageIcon("standards.png"));

		imageIcon_Map.put("couplers", getImageIcon("couplers.png"));

		imageIcon_Map.put("mullions", getImageIcon("mullions.png"));

		imageIcon_Map.put("view", getImageIcon("view.png"));
		
		imageIcon_Map.put("search", getImageIcon("search.png"));
		
		imageIcon_Map.put(
				"dimensioning",
				getImageIcon("dimensioning.png"));

		imageIcon_Map.put("haf", getImageIcon("haf.png"));

		imageIcon_Map.put("viewIn", getImageIcon("viewIn.png"));

		imageIcon_Map.put("viewOut", getImageIcon("viewOut.png"));

		imageIcon_Map.put("openings", getImageIcon("openings.png"));
		imageIcon_Map.put(
				"editprofiles",
				getImageIcon("editprofiles.png"));

		imageIcon_Map.put(
				"overallShape",
				getImageIcon("overallShape.png"));

		imageIcon_Map.put(
				"frameShape",
				getImageIcon("frameShape.png"));
		
		imageIcon_Map.put(
				"overallShapeSelected",
				getImageIcon("overallShapeSelected.png"));

		imageIcon_Map.put(
				"frameShapeSelected",
				getImageIcon("frameShapeSelected.png"));
		
		imageIcon_Map.put(
				"overallShapeUnselected",
				getImageIcon("overallShapeUnselected.png"));

		imageIcon_Map.put(
				"frameShapeUnselected",
				getImageIcon("frameShapeUnselected.png"));

		imageIcon_Map.put("vc", getImageIcon("VCoupler.png"));
		imageIcon_Map.put("hc", getImageIcon("HCoupler.png"));
		imageIcon_Map.put("vm", getImageIcon("VMullion.png"));
		imageIcon_Map.put("hm", getImageIcon("HMullion.png"));

		imageIcon_Map.put("flat", getImageIcon("flat.png"));
		imageIcon_Map.put("bay", getImageIcon("bay.png"));
		imageIcon_Map.put("bow", getImageIcon("bow.png"));
		imageIcon_Map.put("custom", getImageIcon("custom.png"));

		imageIcon_Map.put("sashdims", getImageIcon("sashdims.png"));

		imageIcon_Map.put(
				"switchsash",
				getImageIcon("switchsash.png"));
		imageIcon_Map.put(
				"framelevel",
				getImageIcon("framelevel.png"));
		imageIcon_Map.put("sublevel", getImageIcon("sublevel.png"));

		imageIcon_Map.put(
				"rightbotend",
				getImageIcon("rightbotend.png"));

		imageIcon_Map.put(
				"lefttopend",
				getImageIcon("lefttopend.png"));

		imageIcon_Map.put("part", getImageIcon("part.png"));

		imageIcon_Map.put(
				"profileshape",
				getImageIcon("profileshape.png"));

		imageIcon_Map.put(
				"vandhgrids",
				getImageIcon("vandhgrids.png"));

		imageIcon_Map.put("vgrid", getImageIcon("vgrid.png"));

		imageIcon_Map.put("hgrid", getImageIcon("hgrid.png"));

		imageIcon_Map.put(
				"radiusgrids",
				getImageIcon("radiusgrids.png"));

		imageIcon_Map.put("spokes", getImageIcon("spokes.png"));

		imageIcon_Map.put("allglass", getImageIcon("allglass.png"));

		imageIcon_Map.put("oneglass", getImageIcon("oneglass.png"));

		imageIcon_Map.put(
				"glassClass",
				getImageIcon("glassClass.png"));

		imageIcon_Map.put("width", getImageIcon("width.png"));

		imageIcon_Map.put("oswidth", getImageIcon("oswidth.png"));

		imageIcon_Map.put("height", getImageIcon("height.png"));

		imageIcon_Map.put("osheight", getImageIcon("osheight.png"));

		imageIcon_Map.put("itemno", getImageIcon("itemno.png"));

		imageIcon_Map.put(
				"description",
				getImageIcon("description.png"));

		imageIcon_Map.put("qty", getImageIcon("qty.png"));

		imageIcon_Map.put("location", getImageIcon("location.png"));

		imageIcon_Map.put("supplier", getImageIcon("supplier.png"));

		imageIcon_Map.put("series", getImageIcon("series.png"));

		imageIcon_Map.put("ref1", getImageIcon("ref1.png"));

		imageIcon_Map.put("ref2", getImageIcon("ref2.png"));

		imageIcon_Map.put("uom", getImageIcon("uom.png"));

		imageIcon_Map.put("elevation", getImageIcon("elevation.png"));

		imageIcon_Map.put("cost", getImageIcon("cost.png"));

		imageIcon_Map.put("price", getImageIcon("price.png"));

		imageIcon_Map.put("note", getImageIcon("notes.png"));
		imageIcon_Map.put("addons", getImageIcon("addons.png"));

		imageIcon_Map.put(
				"nominalframe",
				getImageIcon("nominalframe.png"));
		imageIcon_Map.put(
				"actualframe",
				getImageIcon("actualframe.png"));
		imageIcon_Map.put("bkgrd", getImageIcon("bkgrd.png"));
		imageIcon_Map.put(
				"nominalopening",
				getImageIcon("nominalopening.png"));
		imageIcon_Map.put(
				"actualopening",
				getImageIcon("actualopening.png"));
		imageIcon_Map.put("glass", getImageIcon("glass.png"));
		imageIcon_Map.put("dlo", getImageIcon("dlo.png"));
		imageIcon_Map.put("grids", getImageIcon("grids.png"));
		imageIcon_Map.put(
				"toptofloor",
				getImageIcon("toptofloor.png"));
		imageIcon_Map.put(
				"midtofloor",
				getImageIcon("midtofloor.png"));
		imageIcon_Map.put(
				"bottofloor",
				getImageIcon("bottofloor.png"));
		imageIcon_Map.put("subsash", getImageIcon("subsash.png"));

// imageIcon_Map.put("imageFeature",
// getImage("Features16.jpg"));
// imageIcon_Map.put("imageShape", getImage("Shapes.jpg"));
// imageIcon_Map.put("imageOpening",
// getImage("Opening16.jpg"));
// imageIcon_Map.put("imageGlass", getImage("Glass16.jpg"));
// imageIcon_Map.put("imageGrid", getImage("Grid16.jpg"));
		imageIcon_Map.put("imagenogrid", getImageIcon("NoGrids.png"));
		imageIcon_Map.put(
				"imageremoveGrid",
				getImageIcon("RemoveGrid.png"));
		imageIcon_Map.put("imagecutGrid", getImageIcon("Cut16.png"));
		imageIcon_Map.put(
				"imagechangmaterH",
				getImageIcon("ChangeMasterH.png"));
		imageIcon_Map.put(
				"imagechangmaterV",
				getImageIcon("ChangeMasterV.png"));
		imageIcon_Map
				.put("imageaddGrid", getImageIcon("AddGrid.png"));

		imageIcon_Map.put(
				"imageNoGrids",
				getImageIcon("NumGrids.png"));
// imageIcon_Map.put("imageUndo", getImage("Undo.jpg"));
// imageIcon_Map.put("sash11_AB",
// getImage("sash11_AB.png"));
		imageIcon_Map.put("cutCursor", getImageIcon("cutCursor.png"));
		imageIcon_Map.put(
				"hMullionCursor",
				getImageIcon("hMullionCursor.png"));
		imageIcon_Map.put(
				"vMullionCursor",
				getImageIcon("vMullionCursor.png"));
		imageIcon_Map.put(
				"hCouplerCursor",
				getImageIcon("hCouplerCursor.png"));
		imageIcon_Map.put(
				"vCouplerCursor",
				getImageIcon("vCouplerCursor.png"));

		imageIcon_Map.put("shape1", getImageIcon("1.png"));

		imageIcon_Map.put("shape10", getImageIcon("10.png"));

		imageIcon_Map.put("shape90", getImageIcon("90.png")); // png
		imageIcon_Map.put("shape91", getImageIcon("91.png"));
		imageIcon_Map.put("shape92", getImageIcon("92.png"));
		imageIcon_Map.put("shape93", getImageIcon("93.png")); // png

		imageIcon_Map.put("shape100", getImageIcon("100.png"));
		imageIcon_Map.put("shape101", getImageIcon("101.png"));
		imageIcon_Map.put("shape102", getImageIcon("102.png"));
		imageIcon_Map.put("shape103", getImageIcon("103.png"));
		imageIcon_Map.put("shape104", getImageIcon("104.png"));
		imageIcon_Map.put("shape105", getImageIcon("105.png"));
		imageIcon_Map.put("shape106", getImageIcon("106.png"));
		imageIcon_Map.put("shape107", getImageIcon("107.png"));
		imageIcon_Map.put("shape108", getImageIcon("108.png"));
		imageIcon_Map.put("shape109", getImageIcon("109.png"));
		imageIcon_Map.put("shape110", getImageIcon("110.png"));
		imageIcon_Map.put("shape111", getImageIcon("111.png"));
		imageIcon_Map.put("shape112", getImageIcon("112.png"));
		imageIcon_Map.put("shape113", getImageIcon("113.png"));
		imageIcon_Map.put("shape114", getImageIcon("114.png"));
		imageIcon_Map.put("shape115", getImageIcon("115.png"));

		imageIcon_Map.put("shape150", getImageIcon("150.png"));
		imageIcon_Map.put("shape151", getImageIcon("151.png"));
		imageIcon_Map.put("shape152", getImageIcon("152.png"));
		imageIcon_Map.put("shape153", getImageIcon("153.png"));
		imageIcon_Map.put("shape154", getImageIcon("154.png"));
		imageIcon_Map.put("shape155", getImageIcon("155.png"));
		imageIcon_Map.put("shape156", getImageIcon("156.png"));
		imageIcon_Map.put("shape157", getImageIcon("157.png"));

		imageIcon_Map.put("shape160", getImageIcon("160.png"));
		imageIcon_Map.put("shape161", getImageIcon("161.png"));
		imageIcon_Map.put("shape162", getImageIcon("162.png"));
		imageIcon_Map.put("shape163", getImageIcon("163.png"));

		imageIcon_Map.put("shape165", getImageIcon("165.png"));
		imageIcon_Map.put("shape166", getImageIcon("165.png"));
		imageIcon_Map.put("shape167", getImageIcon("165.png"));
		imageIcon_Map.put("shape168", getImageIcon("165.png"));

		imageIcon_Map.put("shape200", getImageIcon("200.png"));
		imageIcon_Map.put("shape201", getImageIcon("201.png"));
		imageIcon_Map.put("shape202", getImageIcon("202.png"));
		imageIcon_Map.put("shape203", getImageIcon("203.png"));
		imageIcon_Map.put("shape204", getImageIcon("204.png"));
		imageIcon_Map.put("shape205", getImageIcon("205.png"));

		imageIcon_Map.put("shape206", getImageIcon("206.png"));
		imageIcon_Map.put("shape207", getImageIcon("207.png"));
		imageIcon_Map.put("shape208", getImageIcon("208.png"));
		imageIcon_Map.put("shape209", getImageIcon("209.png"));
		imageIcon_Map.put("shape210", getImageIcon("210.png"));
		imageIcon_Map.put("shape211", getImageIcon("211.png"));
		imageIcon_Map.put("shape212", getImageIcon("212.png"));
		imageIcon_Map.put("shape213", getImageIcon("213.png"));
		imageIcon_Map.put("shape214", getImageIcon("214.png"));
		imageIcon_Map.put("shape215", getImageIcon("215.png"));
		imageIcon_Map.put("shape216", getImageIcon("216.png"));
		imageIcon_Map.put("shape217", getImageIcon("217.png"));
		imageIcon_Map.put("shape218", getImageIcon("218.png"));
		imageIcon_Map.put("shape219", getImageIcon("219.png"));

		imageIcon_Map.put("shape300", getImageIcon("300.png"));
		imageIcon_Map.put("shape301", getImageIcon("301.png"));
		imageIcon_Map.put("shape302", getImageIcon("302.png"));
		imageIcon_Map.put("shape303", getImageIcon("303.png"));
		imageIcon_Map.put("shape304", getImageIcon("304.png"));
		imageIcon_Map.put("shape305", getImageIcon("305.png"));
		imageIcon_Map.put("shape306", getImageIcon("306.png"));
		imageIcon_Map.put("shape307", getImageIcon("307.png"));
		imageIcon_Map.put("shape308", getImageIcon("308.png"));
		imageIcon_Map.put("shape309", getImageIcon("309.png"));
		imageIcon_Map.put("shape310", getImageIcon("310.png"));
		imageIcon_Map.put("shape311", getImageIcon("311.png"));
		imageIcon_Map.put("shape312", getImageIcon("312.png"));
		imageIcon_Map.put("shape313", getImageIcon("313.png"));
		imageIcon_Map.put("shape314", getImageIcon("314.png"));
		imageIcon_Map.put("shape315", getImageIcon("315.png"));
		imageIcon_Map.put("shape316", getImageIcon("316.png"));
		imageIcon_Map.put("shape317", getImageIcon("317.png"));
		imageIcon_Map.put("shape318", getImageIcon("318.png"));
		imageIcon_Map.put("shape319", getImageIcon("319.png"));

		imageIcon_Map.put("shape400", getImageIcon("400.png"));
		imageIcon_Map.put("shape401", getImageIcon("401.png"));
		imageIcon_Map.put("shape402", getImageIcon("402.png"));

		imageIcon_Map.put("shape450", getImageIcon("450.png"));

		imageIcon_Map.put("shape453", getImageIcon("453.png"));

// imageIcon_Map.put("shape454", getImage("454.jpg"));
// imageIcon_Map.put("shape455", getImage("455.jpg"));
// imageIcon_Map.put("shape456", getImage("456.jpg"));
// imageIcon_Map.put("shape457", getImage("457.jpg"));
// imageIcon_Map.put("shape458", getImage("458.jpg"));
// imageIcon_Map.put("shape459", getImage("459.jpg"));
// imageIcon_Map.put("shape460", getImage("460.jpg"));
// imageIcon_Map.put("shape461", getImage("461.jpg"));

		imageIcon_Map.put("shape700", getImageIcon("700.png"));
		imageIcon_Map.put("shape701", getImageIcon("701.png"));
		imageIcon_Map.put("shape702", getImageIcon("702.png"));
		imageIcon_Map.put("shape703", getImageIcon("703.png"));
		imageIcon_Map.put("shape704", getImageIcon("704.png"));
		imageIcon_Map.put("shape705", getImageIcon("705.png"));
		imageIcon_Map.put("shape706", getImageIcon("706.png"));

		imageIcon_Map.put("shape707", getImageIcon("707.png"));

		imageIcon_Map.put("shape800", getImageIcon("800.png"));
		imageIcon_Map.put("shape801", getImageIcon("801.png"));
		imageIcon_Map.put("shape802", getImageIcon("802.png"));

		imageIcon_Map.put("op1", getImageIcon("1op.png"));

		imageIcon_Map.put("op2", getImageIcon("2op.png"));

		imageIcon_Map.put("op3", getImageIcon("3op.png")); // png
		imageIcon_Map.put("op4", getImageIcon("4op.png"));
		imageIcon_Map.put("op5", getImageIcon("5op.png"));
		imageIcon_Map.put("op6", getImageIcon("6op.png")); // png

		imageIcon_Map.put("op7", getImageIcon("7op.png"));
		imageIcon_Map.put("op8", getImageIcon("8op.png"));
		imageIcon_Map.put("op9", getImageIcon("9op.png"));
		imageIcon_Map.put("op10", getImageIcon("10op.png"));

		imageIcon_Map.put("op11", getImageIcon("11op.png"));
		imageIcon_Map.put("op12", getImageIcon("12op.png"));
		imageIcon_Map.put("op13", getImageIcon("13op.png"));
		imageIcon_Map.put("op14", getImageIcon("14op.png"));
		imageIcon_Map.put("op15", getImageIcon("15op.png"));
		imageIcon_Map.put("op16", getImageIcon("16op.png"));
		imageIcon_Map.put("op17", getImageIcon("17op.png"));

		imageIcon_Map.put("op211", getImageIcon("211op.png"));
		imageIcon_Map.put("op212", getImageIcon("212op.png"));
		imageIcon_Map.put("op213", getImageIcon("213op.png"));
		imageIcon_Map.put("op214", getImageIcon("214op.png"));
		imageIcon_Map.put("op215", getImageIcon("215op.png"));
		imageIcon_Map.put("op216", getImageIcon("216op.png"));
		imageIcon_Map.put("op217", getImageIcon("217op.png"));

		imageIcon_Map.put("op18", getImageIcon("18op.png"));
		imageIcon_Map.put("op218", getImageIcon("18op.png"));

		imageIcon_Map.put("op21", getImageIcon("21op.png"));
		imageIcon_Map.put("op22", getImageIcon("22op.png"));
		imageIcon_Map.put("op23", getImageIcon("23op.png"));
		imageIcon_Map.put("op24", getImageIcon("24op.png"));

		imageIcon_Map.put("op221", getImageIcon("221op.png"));
		imageIcon_Map.put("op222", getImageIcon("222op.png"));
		imageIcon_Map.put("op223", getImageIcon("223op.png"));
		imageIcon_Map.put("op224", getImageIcon("224op.png"));

		imageIcon_Map.put("op31", getImageIcon("31op.png"));
		imageIcon_Map.put("op32", getImageIcon("32op.png"));

		imageIcon_Map.put("op231", getImageIcon("231op.png"));
		imageIcon_Map.put("op232", getImageIcon("232op.png"));

		imageIcon_Map.put("op41", getImageIcon("41op.png"));
		imageIcon_Map.put("op42", getImageIcon("42op.png"));

		imageIcon_Map.put("op43", getImageIcon("43op.png"));
		imageIcon_Map.put("op44", getImageIcon("44op.png"));

		imageIcon_Map.put("op243", getImageIcon("243op.png"));
		imageIcon_Map.put("op244", getImageIcon("244op.png"));

		imageIcon_Map.put("op51", getImageIcon("51op.png"));

		imageIcon_Map.put("op52", getImageIcon("52op.png"));

		imageIcon_Map.put("op61", getImageIcon("61op.png"));

		imageIcon_Map.put("op71", getImageIcon("71op.png"));
		imageIcon_Map.put("op72", getImageIcon("72op.png"));
		imageIcon_Map.put("op73", getImageIcon("73op.png"));

		imageIcon_Map.put("op76", getImageIcon("76op.png"));
		imageIcon_Map.put("op77", getImageIcon("77op.png"));
		imageIcon_Map.put("op78", getImageIcon("78op.png"));

		imageIcon_Map.put("op271", getImageIcon("271op.png"));
		imageIcon_Map.put("op272", getImageIcon("272op.png"));
		imageIcon_Map.put("op273", getImageIcon("273op.png"));

		imageIcon_Map.put("op276", getImageIcon("276op.png"));
		imageIcon_Map.put("op277", getImageIcon("277op.png"));
		imageIcon_Map.put("op278", getImageIcon("278op.png"));

		imageIcon_Map.put("op291", getImageIcon("291op.png"));
		imageIcon_Map.put("op292", getImageIcon("292op.png"));
		imageIcon_Map.put("op293", getImageIcon("293op.png"));

		imageIcon_Map.put("op301", getImageIcon("301op.png"));
		imageIcon_Map.put("op302", getImageIcon("302op.png"));
		imageIcon_Map.put("op303", getImageIcon("303op.png"));

		imageIcon_Map.put("op311", getImageIcon("311op.png"));
		imageIcon_Map.put("op312", getImageIcon("312op.png"));
		imageIcon_Map.put("op313", getImageIcon("313op.png"));
		
		imageIcon_Map.put("3sided", getImageIcon("3sides.png"));
		imageIcon_Map.put("4sided", getImageIcon("4sides.png"));
		imageIcon_Map.put("5sided", getImageIcon("5sides.png"));
		imageIcon_Map.put("6sided", getImageIcon("6sides.png"));
		imageIcon_Map.put("roundtop", getImageIcon("roundtop.png"));
		imageIcon_Map.put("archtop", getImageIcon("archtop.png"));
		imageIcon_Map.put("gothictop", getImageIcon("gothictop.png"));
		imageIcon_Map.put("oddshape", getImageIcon("oddshapes.png"));
		imageIcon_Map.put("1ls", getImageIcon("1ls.png"));
		imageIcon_Map.put("2ls", getImageIcon("2ls.png"));
		imageIcon_Map.put("ns", getImageIcon("ns.png"));
		imageIcon_Map.put("outswing", getImageIcon("outswing.png"));
		imageIcon_Map.put("inswing", getImageIcon("inswing.png"));
		imageIcon_Map.put("folding", getImageIcon("folding.png"));
		imageIcon_Map.put("transoms", getImageIcon("transoms.png"));
		imageIcon_Map.put("sidelights", getImageIcon("sidelights.png"));
		imageIcon_Map.put("kp", getImageIcon("kp.png"));
		
		imageIcon_Map.put("std", getImageIcon("std.png"));
		imageIcon_Map.put("stdset", getImageIcon("stdset.png"));
		

		imageIcon_Map.put(
				"baydetails",
				getImageIcon("baydetails.png"));
		imageIcon_Map.put(
				"bowdetails",
				getImageIcon("bowdetails.png"));

		imageIcon_Map.put(
				"flatdetails",
				getImageIcon("flatdetails.png"));

		imageIcon_Map.put("flatwidth", getImageIcon("flatwidth.png"));

		imageIcon_Map.put(
				"customdetails",
				getImageIcon("customdetails.png"));

		imageIcon_Map.put("refresh", getImageIcon("refresh.png"));

		imageIcon_Map.put("equalize", getImageIcon("equalize16.png"));
		imageIcon_Map.put(
				"equalizeH",
				getImageIcon("equalize16H.png"));
		imageIcon_Map.put("alignV", getImageIcon("alignV16.png"));
		imageIcon_Map.put("alignH", getImageIcon("alignH16.png"));
		imageIcon_Map.put("edit", getImageIcon("edit.png"));
		imageIcon_Map.put("extend", getImageIcon("extend.png"));
		imageIcon_Map.put("removeM", getImageIcon("removeM.png"));

		imageIcon_Map.put("abcDim", getImageIcon("ABCDims.png"));
		imageIcon_Map.put(
				"noLeafsBefore",
				getImageIcon("noOfLeafsBeforeOpen.png"));
		imageIcon_Map.put("noLeafs", getImageIcon("noOfLeafs.png"));

		return imageIcon_Map;
		}

	public static byte[] getResourceJarReadersSrcByte(
			final JApplet jApplet,
			final String imageName)
		{

		InputStream in = null;
		byte b[] = new byte[0];
		int size = 0;
		in =
				((Object) jApplet).getClass().getResourceAsStream(
						"/".concat(String.valueOf(String
								.valueOf(imageName))));
		try
			{
			if (in == null)
				{
//				System.out.println("imageName is: ".concat(String
//						.valueOf(String.valueOf(imageName))));
				}
			size = in.available();
			b = new byte[size];
			in.read(b);
			}
		catch (final IOException e)
			{
			((Throwable) e).printStackTrace();
			}
		catch (final Exception ex)
			{
			((Throwable) ex).printStackTrace();
			}
		return b;
		}

	}
