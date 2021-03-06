/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2014 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.craftercms.studio.impl.v1.executor;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.craftercms.studio.api.v1.constant.CStudioConstants;
import org.craftercms.studio.api.v1.constant.DmConstants;
import org.craftercms.studio.api.v1.exception.ContentProcessException;
import org.craftercms.studio.api.v1.exception.ServiceException;
import org.craftercms.studio.api.v1.executor.ProcessContentExecutor;
import org.craftercms.studio.api.v1.log.Logger;
import org.craftercms.studio.api.v1.log.LoggerFactory;
import org.craftercms.studio.api.v1.content.pipeline.ContentProcessorPipeline;
import org.craftercms.studio.api.v1.content.pipeline.PipelineContent;
import org.craftercms.studio.api.v1.to.ResultTO;
import org.craftercms.studio.impl.v1.content.pipeline.PipelineContentImpl;
import org.craftercms.studio.impl.v1.util.ContentUtils;
import org.craftercms.studio.api.v1.service.security.SecurityService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Dejan Brkic
 */
public class ProcessContentExecutorImpl implements ProcessContentExecutor {

    private static final Logger logger = LoggerFactory.getLogger(ProcessContentExecutorImpl.class);

    @Override
    public ResultTO processContent(String id, InputStream input, boolean isXml, Map<String, String> params, String chainName) throws ServiceException {
        final ContentProcessorPipeline chain = processorChains.get(chainName);
        try{
            if (chain != null) {
                if (StringUtils.isEmpty(params.get(DmConstants.KEY_USER))) {
                    String user = securityService.getCurrentUser();
                    params.put(DmConstants.KEY_USER, user);
                }

                byte[] inputBytes= null;
                try {
                    if (input != null) {
                        inputBytes = IOUtils.toByteArray(input);
                    }
                } catch (IOException e) {
                    throw new ServiceException("Error while creating byte array",e);
                }finally{
                    ContentUtils.release(input);
                }

                final ResultTO result = new ResultTO();
                final byte[] inputBytesFinal = inputBytes;

                InputStream newByteArrayStream=null;
                try {
                    newByteArrayStream = (inputBytesFinal != null) ? new ByteArrayInputStream(inputBytesFinal) : null;
                    final PipelineContent content = new PipelineContentImpl(id, newByteArrayStream, isXml, null, CStudioConstants.CONTENT_ENCODING, params);
                    chain.processContent(content, result);

                } catch (ContentProcessException e) {
                    logger.error("Error in chain for write content", e);
                    throw e;
                } catch (RuntimeException e) {
                    logger.error("Error in chain for write content", e);
                    throw e;
                }finally{
                    ContentUtils.release(newByteArrayStream);
                }
                return result;

            } else {
                ContentUtils.release(input);
                throw new ServiceException(chainName + " is not defined.");
            }
        }finally {
            String s = params.get(DmConstants.KEY_USER);
            //AuthenticationUtil.setFullyAuthenticatedUser(s);
        }
    }

    protected Map<String, ContentProcessorPipeline> processorChains;
    protected SecurityService securityService;
    public SecurityService getSecurityService() {return securityService; }
    public void setSecurityService(SecurityService securityService) { this.securityService = securityService; }

    public Map<String, ContentProcessorPipeline> getProcessorChains() { return processorChains; }
    public void setProcessorChains(Map<String, ContentProcessorPipeline> processorChains) { this.processorChains = processorChains; }
}
