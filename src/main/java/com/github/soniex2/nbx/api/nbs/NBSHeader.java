package com.github.soniex2.nbx.api.nbs;

import com.github.soniex2.nbx.api.stream.nbs.INBSReader;
import com.github.soniex2.nbx.api.stream.nbs.INBSWriter;

import java.io.IOException;

public class NBSHeader {

    private short ticks = 0;
    private short layers = 0;
    private String name = "";
    private String author = "";
    private String originalAuthor = "";
    private String description = "";
    private short tempo = 1000;
    private boolean autosave = false;
    private byte autosaveTime = 1;
    private byte timeSig = 4;
    private int minutes = 0;
    private int lclicks = 0;
    private int rclicks = 0;
    private int blockAdds = 0;
    private int blockBreaks = 0;
    private String importName = "";

    public NBSHeader() {
    }

    public NBSHeader(short ticks, short layers, String name, String author,
                     String originalAuthor, String description, short tempo,
                     boolean autosave, byte autosaveTime, byte timeSig, int minutes,
                     int lclicks, int rclicks, int blockAdds, int blockBreaks,
                     String importName) {
        this.ticks = ticks;
        this.layers = layers;
        this.name = name;
        this.author = author;
        this.originalAuthor = originalAuthor;
        this.description = description;
        this.tempo = tempo;
        this.autosave = autosave;
        this.autosaveTime = autosaveTime;
        this.timeSig = timeSig;
        this.minutes = minutes;
        this.lclicks = lclicks;
        this.rclicks = rclicks;
        this.blockAdds = blockAdds;
        this.blockBreaks = blockBreaks;
        this.importName = importName;
    }

    public short getTicks() {
        return ticks;
    }

    public void setTicks(short ticks) {
        this.ticks = ticks;
    }

    public short getLayers() {
        return layers;
    }

    public void setLayers(short layers) {
        this.layers = layers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginalAuthor() {
        return originalAuthor;
    }

    public void setOriginalAuthor(String originalAuthor) {
        this.originalAuthor = originalAuthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getTempo() {
        return tempo;
    }

    public void setTempo(short tempo) {
        this.tempo = tempo;
    }

    public boolean shouldAutosave() {
        return autosave;
    }

    public void setAutosave(boolean autosave, byte autosaveTime) {
        this.autosave = autosave;
        this.autosaveTime = autosaveTime;
    }

    public byte getAutosaveTime() {
        return autosaveTime;
    }

    public void setAutosaveTime(byte autosaveTime) {
        this.autosaveTime = autosaveTime;
    }

    public byte getTimeSig() {
        return timeSig;
    }

    public void setTimeSig(byte timeSig) {
        this.timeSig = timeSig;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getLClicks() {
        return lclicks;
    }

    public void setLClicks(int lclicks) {
        this.lclicks = lclicks;
    }

    public int getRClicks() {
        return rclicks;
    }

    public void setRClicks(int rclicks) {
        this.rclicks = rclicks;
    }

    public int getBlockAdds() {
        return blockAdds;
    }

    public void setBlockAdds(int blockAdds) {
        this.blockAdds = blockAdds;
    }

    public int getBlockBreaks() {
        return blockBreaks;
    }

    public void setBlockBreaks(int blockBreaks) {
        this.blockBreaks = blockBreaks;
    }

    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public NBSHeader copy() {
        return new NBSHeader(ticks, layers, name, author, originalAuthor,
                description, tempo, autosave, autosaveTime, timeSig, minutes,
                lclicks, rclicks, blockAdds, blockBreaks, importName);
    }

    public static NBSHeader read(INBSReader reader) throws IOException {
        return new NBSHeader(reader.readShort(), reader.readShort(), reader.readASCII(),
                reader.readASCII(), reader.readASCII(), reader.readASCII(), reader.readShort(),
                reader.readBoolean(), reader.readByte(), reader.readByte(), reader.readInt(), reader.readInt(),
                reader.readInt(), reader.readInt(), reader.readInt(), reader.readASCII());
    }

    public void write(INBSWriter writer) throws IOException {
        writer.writeShort(ticks);
        writer.writeShort(layers);
        writer.writeASCII(name);
        writer.writeASCII(author);
        writer.writeASCII(originalAuthor);
        writer.writeASCII(description);
        writer.writeShort(tempo);
        writer.writeBoolean(autosave);
        writer.write(autosaveTime);
        writer.write(timeSig);
        writer.writeInt(minutes);
        writer.writeInt(lclicks);
        writer.writeInt(rclicks);
        writer.writeInt(blockAdds);
        writer.writeInt(blockBreaks);
        writer.writeASCII(importName);
    }

}