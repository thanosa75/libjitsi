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
package org.jitsi.impl.neomedia.rtcp;

import net.sf.fmj.media.rtp.*;
import org.jitsi.impl.neomedia.*;

import java.util.*;

/**
 * Not thread safe.
 *
 * @author George Politis
 */
public class RTCPIterator
    implements Iterator<RawPacket>
{
    /**
     * The {@code RawPacket} that holds the RTCP packet to iterate.
     */
    private final byte[] buf;

    /**
     * The offset in the {@link #buf} where the next packet is to be looked for.
     */
    private int off;

    /**
     * The remaining length in {@link #buf}.
     */
    private int len;

    /**
     * The length of the last next element.
     */
    private int lastLen;

    /**
     * Ctor.
     *
     * @param pkt The {@code RawPacket} that holds the RTCP packet to iterate.
     */
    public RTCPIterator(RawPacket pkt)
    {
        this.buf = pkt.getBuffer();
        this.off = pkt.getOffset();
        this.len = pkt.getLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext()
    {
        return RTCPHeaderUtils.getLength(buf, off, len) >= RTCPHeader.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RawPacket next()
    {
        int pktLen = RTCPHeaderUtils.getLength(buf, off, len);
        if (pktLen < RTCPHeader.SIZE)
        {
            throw new IllegalStateException();
        }

        RawPacket next = new RawPacket(buf, off, pktLen);

        lastLen = pktLen;
        off += pktLen;
        len -= pktLen;

        if (len < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        return next;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove()
    {
        if (lastLen == 0)
        {
            throw new IllegalStateException();
        }

        System.arraycopy(buf, off, buf, off - lastLen, len);

        lastLen = 0;
    }

}
