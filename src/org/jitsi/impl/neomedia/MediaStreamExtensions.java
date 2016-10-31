/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.impl.neomedia;

import net.sf.fmj.media.rtp.*;
import org.jitsi.impl.neomedia.rtcp.*;
import org.jitsi.service.neomedia.*;
import org.jitsi.util.*;

import java.util.*;

/**
 * Utility methods that extend the {@code MediaStream}.
 *
 * @author George Politis
 */
public class MediaStreamExtensions
{
    /**
     * @param stream
     * @return
     */
    public static RTPEncodingResolver getRTPEncodingResolver(MediaStream stream)
    {
        Object resolver = stream.getProperty(RTPEncodingResolver.class.getName());
        if (resolver != null)
        {
            return (RTPEncodingResolver) resolver;
        }

        return null;
    }

    /**
     * @param stream
     * @return
     */
    public static MediaStreamTrackResolver getMediaStreamTrackResolver(
        MediaStream stream)
    {
        Object resolver = stream.getProperty(MediaStreamTrackResolver.class.getName());
        if (resolver != null)
        {
            return (MediaStreamTrackResolver) resolver;
        }

        return null;
    }

    /**
     *
     * @param stream
     * @return
     */
    public static BitrateController getBitrateController(MediaStream stream)
    {
        Object bitrateController = stream.getProperty(BitrateController.class.getName());
        if (bitrateController != null)
        {
            return (BitrateController) bitrateController;
        }

        return null;
    }
}
