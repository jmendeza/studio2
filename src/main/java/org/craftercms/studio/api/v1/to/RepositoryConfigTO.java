/*******************************************************************************
 * Crafter Studio Web-content authoring solution
 *     Copyright (C) 2007-2013 Crafter Software Corporation.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.craftercms.studio.api.v1.to;

import java.io.Serializable;
import java.util.List;

public class RepositoryConfigTO implements Serializable {

    private static final long serialVersionUID = 1148516942728141172L;


    /** root prefix **/
    protected String rootPrefix;
    /** level descriptor name **/
    protected String levelDescriptorName;
    /** top level folders **/
    protected List<DmFolderConfigTO> folders = null;
    /** a list of paths to exclude when traversing file/folder hierarchy **/
    //protected List<String> _excludePaths = null;

    /** page path patterns **/
    protected List<String> pagePatterns = null;
    /** component path patterns **/
    protected List<String> componentPatterns = null;
    /** assets path patterns **/
    protected List<String> assetPatterns = null;
    /** document path patterns **/
    protected List<String> documentPatterns = null;
    /** rendering template path patterns **/
    protected List<String> renderingTemplatePatterns = null;
    /** level descriptors path patterns **/
    protected List<String> levelDescriptorPatterns = null;

    /** content to display in widgets **/
    protected List<String> displayPatterns = null;

    /** periodically index repository? **/
    //protected boolean _indexRepository = false;
    /** index life time. default = 1 hour **/
    //protected long _indexTimeToLive = 3600000;

    //protected boolean _checkForRenamed = false;

    /** common template configuration **/
    //protected TemplateConfigTO _templateConfig = null;

    /** previewable mimetypes patterns **/
    private List<String> previewableMimetypesPaterns;

    /**
     * @return the rootPrefix
     */
    public String getRootPrefix() {
        return rootPrefix;
    }

    /**
     * @param rootPrefix
     *            the rootPrefix to set
     */
    public void setRootPrefix(String rootPrefix) {
        this.rootPrefix = rootPrefix;
    }

    /**
     * @return the folders
     */
    public List<DmFolderConfigTO> getFolders() {
        return folders;
    }

    /**
     * @param folders
     *            the folders to set
     */
    public void setFolders(List<DmFolderConfigTO> folders) {
        this.folders = folders;
    }

    /**
     * @param pagePatterns the pagePatterns to set
     */
    public void setPagePatterns(List<String> pagePatterns) {
        this.pagePatterns = pagePatterns;
    }

    /**
     * @return the pagePatterns
     */
    public List<String> getPagePatterns() {
        return pagePatterns;
    }

    /**
     * @param componentPatterns the componentPatterns to set
     */
    public void setComponentPatterns(List<String> componentPatterns) {
        this.componentPatterns = componentPatterns;
    }

    /**
     * @return the componentPatterns
     */
    public List<String> getComponentPatterns() {
        return componentPatterns;
    }

    /**
     * @param assetPatterns the assetPatterns to set
     */
    public void setAssetPatterns(List<String> assetPatterns) {
        this.assetPatterns = assetPatterns;
    }

    /**
     * @return the assetPatterns
     */
    public List<String> getAssetPatterns() {
        return assetPatterns;
    }

    /**
     * get the root path of the given category (e.g. /site/website for Pages)
     *
     * @param category
     * @return the category root path
     *//*
    public String getCategoryRootPath(String category) {
        if (_folders != null) {
            for (DmFolderConfigTO folder : _folders) {
                if (folder.getName().equals(category)) {
                    return folder.getPath();
                }
            }
        }
        return "";
    }*/

    /**
     * @param levelDescriptorName the levelDescriptorName to set
     */
    public void setLevelDescriptorName(String levelDescriptorName) {
        this.levelDescriptorName = levelDescriptorName;
    }

    /**
     * @return the levelDescriptorName
     */
    public String getLevelDescriptorName() {
        return levelDescriptorName;
    }

    /**
     * @param checkForRenamed the checkForRenamed to set
     *//*
    public void setCheckForRenamed(boolean checkForRenamed) {
        this._checkForRenamed = checkForRenamed;
    }*/

    /**
     * @return the useCollaborativeSandbox
     *//*
    public boolean isCheckForRenamed() {
        return this._checkForRenamed;
    }*/

    /**
     * @param indexRepository the indexRepository to set
     *//*
    public void setIndexRepository(boolean indexRepository) {
        this._indexRepository = indexRepository;
    }*/

    /**
     * @return the indexRepository
     *//*
    public boolean isIndexRepository() {
        return _indexRepository;
    }*/

    /**
     * @param indexTimeToLive the indexTimeToLive to set
     *//*
    public void setIndexTimeToLive(long indexTimeToLive) {
        this._indexTimeToLive = indexTimeToLive;
    }*/

    /**
     * @return the indexTimeToLive
     *//*
    public long getIndexTimeToLive() {
        return _indexTimeToLive;
    }*/

    /**
     * @param documentPatterns the documentPatterns to set
     */
    public void setDocumentPatterns(List<String> documentPatterns) {
        this.documentPatterns = documentPatterns;
    }

    /**
     * @return the documentPatterns
     */
    public List<String> getDocumentPatterns() {
        return documentPatterns;
    }

    /**
     * @return the excludePaths
     *//*
    public List<String> getExcludePaths() {
        return _excludePaths;
    }*/

    /**
     * @param excludePaths the excludePaths to set
     *//*
    public void setExcludePaths(List<String> excludePaths) {
        this._excludePaths = excludePaths;
    }*/

    /**
     * @param displayPatterns the displayPatterns to set
     */
    public void setDisplayPatterns(List<String> displayPatterns) {
        this.displayPatterns = displayPatterns;
    }

    /**
     * @return the displayPatterns
     */
    public List<String> getDisplayPatterns() {
        return displayPatterns;
    }

    /**
     * @return the templateConfig
     *//*
    public TemplateConfigTO getTemplateConfig() {
        if (_templateConfig == null) {
            _templateConfig = new TemplateConfigTO();
        }
        return _templateConfig;
    }*/

    /**
     * @param templateConfig the templateConfig to set
     *//*
    public void setTemplateConfig(TemplateConfigTO templateConfig) {
        this._templateConfig = templateConfig;
    }*/


    public List<String> getPreviewableMimetypesPaterns() {
        return previewableMimetypesPaterns;
    }


    public void setPreviewableMimetypesPaterns(List<String> patterns) {
        this.previewableMimetypesPaterns = patterns;
    }

    public List<String> getRenderingTemplatePatterns() {
        return this.renderingTemplatePatterns;
    }

    public void setRenderingTemplatePatterns(List<String> paterns) {
        this.renderingTemplatePatterns = paterns;
    }

    public List<String> getLevelDescriptorPatterns() {
        return this.levelDescriptorPatterns;
    }

    public void setLevelDescriptorPatterns(List<String> patterns) {
        this.levelDescriptorPatterns = patterns;
    }
}
