// Copyright (c) Keith D Gregory
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.kdgregory.log4j.testhelpers.aws.kinesis;

import com.kdgregory.log4j.aws.KinesisAppender;
import com.kdgregory.log4j.aws.internal.kinesis.KinesisWriterConfig;
import com.kdgregory.log4j.aws.internal.shared.LogWriter;
import com.kdgregory.log4j.aws.internal.shared.WriterFactory;


public class MockKinesisWriterFactory implements WriterFactory<KinesisWriterConfig>
{
    public KinesisAppender appender;

    public int invocationCount = 0;
    public MockKinesisWriter writer;


    public MockKinesisWriterFactory(KinesisAppender appender)
    {
        this.appender = appender;
    }


    @Override
    public LogWriter newLogWriter(KinesisWriterConfig config)
    {
        invocationCount++;
        writer = new MockKinesisWriter(config);
        return writer;
    }
}
